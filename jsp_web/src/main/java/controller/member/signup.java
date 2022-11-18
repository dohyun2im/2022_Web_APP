package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.memberDao;
import model.dto.memberDto;

@WebServlet("/member/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public signup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mconpw = request.getParameter("mconpw");
		String mname = request.getParameter("mname");
		String mpn = request.getParameter("mpn");
		String memail = request.getParameter("memail");
		String maddr1 = request.getParameter("addr1");
		String maddr2 = request.getParameter("addr2");
		String maddr3 = request.getParameter("addr3");
		String maddr4 = request.getParameter("addr4");
		String maddr = maddr1+","+maddr2+","+maddr3+","+maddr4;
		
		memberDto dto = new memberDto(0, mid, mpw, mname, mpn, memail, maddr, null , 0);
		
		System.out.println(dto.toString());
		boolean result = memberDao.getInstance().signup(dto);		
		if(result){response.sendRedirect("/jsp_web/member/login.jsp");}
	}

}
