package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

import model.dao.memberDao;
import model.dto.memberDto;

@WebServlet("/member/infolist")
public class infolist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public infolist() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<memberDto> list = memberDao.getInstance().getinfolist();
		JSONArray array = new JSONArray();
		
		for(memberDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("mno", dto.getMnum());
			object.put("mid", dto.getMid());
			object.put("mname", dto.getMname());
			object.put("mpn", dto.getMpn());
			object.put("memail", dto.getMemail());
			object.put("maddr", dto.getMaddr());
			object.put("mdate", dto.getMdate());
			object.put("mpoint", dto.getMpoint());	
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
