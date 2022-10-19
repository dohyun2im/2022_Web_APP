package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.boardDao;
import model.dto.boardDto;

/**
 * Servlet implementation class boarddetail
 */
@WebServlet("/board/boarddetail")
public class boarddetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boarddetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		boardDto dto = boardDao.getInstance().bdetail(bnum);
		JSONObject object = new JSONObject();
		object.put("mid", dto.getMid());
		object.put("bnum", dto.getBnum());
		object.put("btitle", dto.getBtitle());
		object.put("bcon", dto.getBcon());
		object.put("bdate", dto.getBdate());
		object.put("bview", dto.getBview());
		object.put("bfile", dto.getBfile());
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
