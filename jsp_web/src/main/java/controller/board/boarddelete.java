package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.boardDao;
import model.dao.memberDao;
import model.dto.boardDto;

/**
 * Servlet implementation class boarddelete
 */
@WebServlet("/board/boarddelete")
public class boarddelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public boarddelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String)request.getSession().getAttribute("mid");
		int mnum = memberDao.getInstance().getMnum(mid);
		String bdnum = request.getParameter("bdnum");
		System.out.println(bdnum);
		System.out.println(mnum);
		
		boardDto dto = boardDao.getInstance().bdetail(Integer.parseInt(bdnum));
		boolean result = boardDao.getInstance().bdelete(bdnum,mnum);
		if(result) {
			File file = new File(request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile()));
			if(file.exists()) {file.delete();} 
		}
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

