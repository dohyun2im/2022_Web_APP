package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.boardDao;
import model.dto.boardDto;

/**
 * Servlet implementation class boardlist
 */
@WebServlet("/board/boardlist")
public class boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	//검색처리
    	String key = request.getParameter("key");
    	String keyword = request.getParameter("keyword"); 
    	//페이지당 게시물 수
    	int listsize =  Integer.parseInt(request.getParameter("listsize"));
    	//전체 게시물 수 vs 검색된 게시물수
    	int totalsize = boardDao.getInstance().gettotalsize();
    	//현재페이지번호
    	int page = Integer.parseInt(request.getParameter("page"));
    	//필요한 페이지
    	int totalpage = 0;
    	if(totalsize%listsize!=0) {
    		totalpage=totalsize/listsize+1;
    	}
    	else {totalpage=totalsize/listsize;}
    	//시작 게시물 번호
    	int startrow = listsize*(page-1);
    	
    	JSONObject boards = new JSONObject();
    	
    	ArrayList<boardDto> list = boardDao.getInstance().boardlist(startrow,listsize,key,keyword);
		JSONArray array = new JSONArray();
		for(boardDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("mid", dto.getMid());
			object.put("bnum", dto.getBnum());
			object.put("btitle", dto.getBtitle());
			object.put("bcon", dto.getBcon());
			object.put("bdate", dto.getBdate());
			object.put("bview", dto.getBview());
			array.add(object);
		}
		boards.put("totalpage", totalpage);
		boards.put("totalsize", totalsize);
		boards.put("data", array);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
