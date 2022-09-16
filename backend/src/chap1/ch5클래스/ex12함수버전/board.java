package chap1.ch5클래스.ex12함수버전;

public class board {
	//필드
	String title;
	String content;
	String writer;
	String password;
	int view;
	//생성자
	public board() {}
	public board(String title, String content, String writer, String password, int view) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.view = view;
	}	
	//메소드
}
