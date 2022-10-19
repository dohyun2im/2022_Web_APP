package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.memberDao;
import model.dto.memberDto;

/**
 * Servlet implementation class info
 */
@WebServlet("/member/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public info() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청
		String mid = (String)request.getSession().getAttribute("mid");
		response.setCharacterEncoding("UTF-8");
		//2.db
		memberDto dto =  memberDao.getInstance().getinfo(mid);
		//dto변환 --> json형식 외부라이브러리
		JSONObject object = new JSONObject();
			object.put("mno", dto.getMnum());
			object.put("mid", dto.getMid());
			object.put("mname", dto.getMname());
			object.put("mpn", dto.getMpn());
			object.put("memail", dto.getMemail());
			object.put("maddr", dto.getMaddr());
			object.put("mdate", dto.getMdate());
			object.put("mpoint", dto.getMpoint());			
		//3.응답
			response.getWriter().print(object);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
