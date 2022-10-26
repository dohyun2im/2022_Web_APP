package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray array = new JSONArray();
		ArrayList<productDto> list = new productDao().getproductlist();
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
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

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
