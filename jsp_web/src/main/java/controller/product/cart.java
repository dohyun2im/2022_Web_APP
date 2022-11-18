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
import model.dto.cartDto;


@WebServlet("/product/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public cart() {super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int mno = memberDao.getInstance().getMnum((String)request.getSession().getAttribute("mid"));
		ArrayList<cartDto> list = new productDao().getcart(mno);
		JSONArray array = new JSONArray();
		System.out.println(mno);
		System.out.println(list);
		for(cartDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("cartno",dto.getCartno());
			object.put("pstno",dto.getPstno());
			object.put("pname",dto.getPname());
			object.put("pimg",dto.getPimg());
			object.put("pprice",dto.getPprice());
			object.put("pdiscount",dto.getPdiscount());
			object.put("pcolor",dto.getPcolor());
			object.put("psize",dto.getPssize());
			object.put("amount",dto.getAmount());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = memberDao.getInstance().getMnum((String)request.getSession().getAttribute("mid"));
		String a = request.getParameter("data");
		try {
				
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(a);
			
			for(int i=0; i<array.size(); i++) {
				JSONObject object = (JSONObject)array.get(i);
				String psize = String.valueOf(object.get("psize")) ;
				int amount = Integer.parseInt(String.valueOf(object.get("amount"))) ;
				String pcolor = String.valueOf(object.get("pcolor")) ;
				boolean result = new productDao().setcart(mno,pno,psize,amount,pcolor);
				if(result==false) {
					response.getWriter().print(result); 
					return;
				}
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
		response.getWriter().print(true);
	}

}
