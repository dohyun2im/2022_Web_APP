package chap1.ch5클래스.ex12함수버전;

public class controller {
	static board[] boardlist = new board[100];
	
	//표 만들기
	static boolean con_regist(String title, String content,String writer,String password) {
		board board = new board(title,content,writer,password,0);
		for(int i=0 ; i<boardlist.length ; i++) {
			if(boardlist[i]==null) {
				boardlist[i]=board;
				return true;
			}
		}
		return false;
	}
	
	//삭제함수
	static boolean con_delete(int bNum , String password) {
		if(pwtest(bNum,password)) {
			for(int i = bNum ; i<boardlist.length;i++) {
				boardlist[i]=boardlist[i+1];
				if(boardlist[i+1]==null) {break;}
			}
			return true;
		}
		else {return false;}
	}
	
	//수정함수
	static boolean con_update(int bNum , String password , String title , String content) {
		if(pwtest(bNum,password)) {
			boardlist[bNum].title=title;
			boardlist[bNum].content=content;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//비밀번호 검증
	static boolean pwtest(int bNum , String password) {
		if(controller.boardlist[bNum].password.equals(password)) {
			return true;
		}
		else {return false;}
	}
	
	
}
