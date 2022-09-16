package chap1.ch5클래스.ex13DB버전;

public class boardControl {
	boardDao boardDao = new boardDao();
	
	boolean regist(String b_title,String b_content,
				   String b_writer,String b_password){
		boardDto boardDto = new boardDto(0, b_title, b_content, b_writer, b_password, 0);
		boolean result = boardDao.regist(boardDto);
		return result;
	}
	boardDto[] getBoardlist() {
		boardDto[] boardlist = null;
		boardlist=boardDao.getBoardlist();
		return boardlist;
	}
	
	boardDto getBoard(int b_num) {
		boardDto board = null;
		board = boardDao.getBoard(b_num);
		return board;
	}
	
	boolean update(int b_num ,String b_password,String new_title,String new_content) {
	
		return false;
	}
	
	boolean delete(int b_num , String b_password) {
		return false;
	}
}
