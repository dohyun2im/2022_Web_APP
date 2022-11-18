package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.productDao;
import model.dto.productDto;

@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regist() {
        super();
    }
    //제품수정
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/admin/pimg"), 
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
		String pname = multi.getParameter("pname");							 System.out.println(pname);
		String pcomment = multi.getParameter("pcomment");					 System.out.println(pcomment);
		int pprice = Integer.parseInt(multi.getParameter("pprice"));		 System.out.println(pprice);
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount")); System.out.println(pdiscount);
		String pimg = multi.getFilesystemName("pimg");						 System.out.println(pimg);
		byte pactive = Byte.parseByte(multi.getParameter("pactive")); 		 System.out.println(pactive);
		int pcno = Integer.parseInt(multi.getParameter("pcno"));				 System.out.println(pcno);
		int pno = Integer.parseInt(multi.getParameter("pno"));				 System.out.println(pno);
		
    	
		//파일 지울건지 스위치
    	boolean bfilechange = true;
    	//기존의 상품 가져와보기
		String oldimg = new productDao().getproduct(pno).getPimg();
		
		 // *. 수정시 첨부파일 등록이 없을때 [ 기존첨부파일 넣어주기  ]
		if( pimg == null ) {  pimg = oldimg; bfilechange =false; }
		
		productDto dto = new productDto(pno, pname, pcomment, pprice, pdiscount, pactive, pimg, null, pcno);

		boolean result = new productDao().updateproduct(dto);
		
		// 4.dao 처리 [ 업데이트 = 새로운 첨부파일 ]
		if( result && bfilechange ) {  deletefile( request.getSession() , oldimg ); }
		response.getWriter().print(result);
    }
    
    //파일삭제 함수
    public void deletefile( HttpSession session ,  String pimg ) {
		String deletepath = session.getServletContext().getRealPath("/admin/pimg/"+ pimg );
		File file = new File( deletepath );
		if( file.exists() ) file.delete();	// 해당 경로에 존재하는 파일을 삭제
	}
    
    //제품삭제 
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int pno = Integer.parseInt(request.getParameter("pno"));
    	boolean result = new productDao().deleteproduct(pno);
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().print(result);
    }
    //리스트출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		System.out.println(type);
		
		response.setCharacterEncoding("UTF-8");
		if(type.equals("1")) {
			System.out.println("전체");
			//전체출력 
			String option = request.getParameter("option");
			JSONArray array = new JSONArray();
			ArrayList<productDto> list = new productDao().getproductlist(option);
			for(productDto a : list) {
				JSONObject object = new JSONObject();
				object.put("pno", a.getPno());
				object.put("pname", a.getPname());
				object.put("pcomment", a.getPcomment());
				object.put("pprice", a.getPprice());
				object.put("pdiscount", a.getPdiscount());
				object.put("pactive", a.getPactive());
				object.put("pimg", a.getPimg());
				object.put("pdate", a.getPdate());
				object.put("pcno", a.getPcno());
				array.add(object);
			}
			response.getWriter().print(array);
		}
		else if(type.equals("2")) {
			System.out.println("개별");
			//개별출력
			int pno = Integer.parseInt(request.getParameter("pno"));
			
			productDto dto = new productDao().getproduct(pno);
			
			JSONObject object = new JSONObject();
			object.put("pno", dto.getPno());
			object.put("pname", dto.getPname());
			object.put("pcomment", dto.getPcomment());
			object.put("pprice", dto.getPprice());
			object.put("pdiscount", dto.getPdiscount());
			object.put("pactive", dto.getPactive());
			object.put("pimg", dto.getPimg());
			object.put("pdate", dto.getPdate());
			object.put("pcno", dto.getPcno());
			
			response.getWriter().print(object);
		}		
	}
	//입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/admin/pimg"), 
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
		String pname = multi.getParameter("pname");							 System.out.println(pname);
		String pcomment = multi.getParameter("pcomment");					 System.out.println(pcomment);
		int pprice = Integer.parseInt(multi.getParameter("pprice"));		 System.out.println(pprice);
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount")); System.out.println(pdiscount);
		String pimg = multi.getFilesystemName("pimg");						 System.out.println(pimg);
		int pcno = Integer.parseInt(multi.getParameter("pcno"));			 System.out.println(pcno);
		productDto dto = new productDto(0, pname, pcomment, pprice, pdiscount, (byte)0, pimg, null, pcno);
		boolean result = new productDao().setproduct(dto);
		response.getWriter().print(result);
	}

}
