package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.loginDao;
import model.dao.memberDao;
import model.dto.loginDto;

@WebServlet("/member/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public login() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		loginDto dto = new loginDto(mid, mpw);
		boolean result = loginDao.getInstance().login(dto);
		if(result){
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid);		
		}
		response.getWriter().print(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		loginDto dto = new loginDto(mid, mpw);
		
		boolean result = loginDao.getInstance().login(dto);
		
		if(result){
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid);
			response.sendRedirect("/jsp_web/index.jsp");
		}
		response.getWriter().print(result);
	}

}
