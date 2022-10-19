package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.boardDao;
import model.dao.memberDao;
import model.dto.boardDto;

/**
 * Servlet implementation class boardupdate
 */
@WebServlet("/board/boardupdate")
public class boardupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		request.getSession().setAttribute("bnum", bnum);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cos필요 (요청방식, 파일저장경로, 최대허옹용량(바이트) , 인코딩타입 , 기타보안)
			//프로젝트에 저장 / 
		int bnum = (Integer)request.getSession().getAttribute("bnum");
		
		//String uploadpath = "C:\\Users\\504\\git\\2022_Web_APP\\jsp_web\\src\\main\\webapp\\upload";
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
		
		MultipartRequest multi = new MultipartRequest(
				request,uploadpath,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
				
		String btitle = multi.getParameter("btitle");
				
		String bcon = multi.getParameter("bcon");
				
		String bfile = multi.getFilesystemName("bfile");  
		String dfile = boardDao.getInstance().bdetail(bnum).getBfile();

		if(bfile==null) {
			bfile=dfile;
		}
		else {
			File file = new File(request.getSession().getServletContext().getRealPath("/upload/"+dfile));
			if(file.exists()) {file.delete();} 
		}
		boolean result = boardDao.getInstance().bupdate(btitle, bcon,bnum,bfile);
		response.getWriter().print(result);
	}

}
