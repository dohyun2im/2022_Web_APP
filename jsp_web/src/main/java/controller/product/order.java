package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.dao.memberDao;
import model.dao.productDao;
import model.dto.orderDto;

/**
 * Servlet implementation class order
 */
@WebServlet("/product/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String checkplist = request.getParameter("checkplist");
		String orderinfo = request.getParameter("orderinfo");
		int mno = memberDao.getInstance().getMnum((String)request.getSession().getAttribute("mid"));
		boolean result = false;
		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(orderinfo);
			JSONArray array  = (JSONArray) parser.parse(checkplist);
			String oname = String.valueOf(object.get("oname"));
			String ophone = String.valueOf(object.get("ophone"));
			String oaddress = String.valueOf(object.get("oaddr"));
			String orequest = String.valueOf(object.get("orequest"));
			ArrayList<orderDto> list = new ArrayList<>();
			for(int i=0; i<array.size(); i++) {
				JSONObject object2 = (JSONObject)array.get(i);
				
				int odamount = Integer.parseInt(String.valueOf(object2.get("amount")));
				int pprice = Integer.parseInt(String.valueOf(object2.get("pprice")));
				float pdiscount = Float.parseFloat(String.valueOf(object2.get("pdiscount")));
				int odprice = Math.round(pprice-(pprice*pdiscount));
				int pstno = Integer.parseInt(String.valueOf(object2.get("pstno")));
				
				orderDto dto = new orderDto(0,oname, ophone, oaddress, orequest, null, mno, 0, odamount, odprice, 0, pstno);
				System.out.println(dto.toString());
				list.add(dto);
			}
			result = new productDao().setorder(list);
		} 
		catch (Exception e) {
			System.out.println(e+"json 형변환 오류");
		}
		response.getWriter().print(result);
	}

}
