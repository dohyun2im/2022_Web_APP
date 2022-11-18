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
import model.dto.stockDto;

/**
 * Servlet implementation class stock
 */
@WebServlet("/admin/stock")
public class stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //재고출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		ArrayList<stockDto> list = new productDao().getstock(pno);
		JSONArray array = new JSONArray();
		for(stockDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("psno", dto.getPsno());
			object.put("psize", dto.getPssize());
			object.put("pstno", dto.getPstno());
			object.put("pcolor", dto.getPcolor());
			object.put("pstock", dto.getPstock());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//재고등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String psize = request.getParameter("psize");
		int pno = Integer.parseInt(request.getParameter("pno"));
		String pcolor = request.getParameter("pcolor");
		int pstock = Integer.parseInt(request.getParameter("pstock"));
		
		boolean result = new productDao().setstock(psize,pno,pcolor,pstock);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
