package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.memberDao;


@WebServlet("/member/findpw")
public class findpw extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public findpw() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		boolean result = memberDao.getInstance().findpw(mid, memail);
		String randstr = "";
		if(result) {
			Random rd = new Random();	
			for(int i=0; i<15 ;i++) {
				randstr += (char)(rd.nextInt(26)+97);
			}
		}
		memberDao.getInstance().pwchange(mid, randstr);
		response.getWriter().print(randstr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
