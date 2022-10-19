package controller.board;

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

@WebServlet("/board/boardwrite")
public class boardwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public boardwrite() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String)request.getSession().getAttribute("mid");
		int mnum = memberDao.getInstance().getMnum(mid);
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcon");
		System.out.println(btitle);
		System.out.println(bcontent);
		boolean result = boardDao.getInstance().board(btitle, bcontent , mnum );
	
		/* js 전송용  */
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cos필요 (요청방식, 파일저장경로, 최대허옹용량(바이트) , 인코딩타입 , 기타보안)
		//프로젝트에 저장 / 
		int mnum = memberDao.getInstance().getMnum((String)request.getSession().getAttribute("mid"));
		//개발중인 프로젝트폴더에 저장된거
		//String uploadpath = "C:\\Users\\504\\git\\2022_Web_APP\\jsp_web\\src\\main\\webapp\\upload";
		//서버폴더에 넣는법
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println(uploadpath);
		
		MultipartRequest multi = new MultipartRequest(
				request,uploadpath,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
		
		String btitle = multi.getParameter("btitle");
		
		String bcon = multi.getParameter("bcon");
		
		String bfile = multi.getFilesystemName("bfile");  
		
		boolean result = boardDao.getInstance().board2(btitle, bcon,mnum,bfile);
		response.getWriter().print(result);
	}

}
