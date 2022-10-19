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
 * Servlet implementation class view
 */
@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = (Integer)request.getSession().getAttribute("bno");
		boardDto dto = boardDao.getInstance().bdetail(bno);
		JSONObject object = new JSONObject();
		object.put("mid", dto.getMid());
		object.put("bnum",dto.getBnum());
		object.put("btitle",dto.getBtitle());
		object.put("bcon",dto.getBcon());
		object.put("bfile", dto.getBfile());
		//삭제수정버튼 활성화 식별변수선언
		String mid = (String)request.getSession().getAttribute("mid");
		
		if(mid!=null && mid.equals(dto.getMid())) {
			object.put("btnaction", true);
		}
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
