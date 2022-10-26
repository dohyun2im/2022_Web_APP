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

import model.dao.productDao;
import model.dto.categoryDto;

/**
 * Servlet implementation class pcategory
 */
@WebServlet("/board/pcategory")
public class pcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<categoryDto> list = new productDao().getpcategory();
		JSONArray array = new JSONArray();
		for(categoryDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("pcno", dto.getPcno());
			object.put("pcname", dto.getPcname());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pcname = request.getParameter("pcname");
		boolean result = new productDao().setpcategory(pcname);
		response.getWriter().print(result);
	}

}
