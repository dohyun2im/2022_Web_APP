package controller.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.boardDao;
import model.dao.commentDao;
import model.dao.memberDao;

@WebServlet("/com/comwrite")
public class comwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String type= request.getParameter("type");
		
		String com = request.getParameter("com");
		int mnum = memberDao.getInstance().getMnum((String)request.getSession().getAttribute("mid"));
		int bnum = (int) request.getSession().getAttribute("bno");
		boolean result = false;
		
		if(type.equals("cocomment")) {
			int cnum = Integer.parseInt(request.getParameter("cnum"));
			result = commentDao.getInstance().cocomment(mnum, bnum, com,cnum);
		}
		else if(type.equals("comment")) {
			result = commentDao.getInstance().comment(mnum, bnum, com);
		}

		if(result && mnum>0) {
			response.getWriter().print(result);
		}
		else{
			response.getWriter().print(2);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
