package controller.com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.commentDao;
import model.dto.commentDto;

/**
 * Servlet implementation class comlist
 */
@WebServlet("/com/comlist")
public class comlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bnum = (int) request.getSession().getAttribute("bno");
		
		String type = request.getParameter("type");
		
		JSONArray array = new JSONArray();
		ArrayList<commentDto> list=null;
		if(type.equals("reply")) {
			list = commentDao.getInstance().comlist(bnum);
		}
		else if(type.equals("rereply")){
			int cindex = Integer.parseInt(request.getParameter("cindex"));
			list = commentDao.getInstance().comcomlist(bnum,cindex);
		}

		
		
		
		for(commentDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("mid", dto.getMid());
			object.put("com", dto.getCom());
			object.put("cdate", dto.getDate());
			object.put("cnum", dto.getCnum());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
