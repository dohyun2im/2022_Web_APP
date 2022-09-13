package chap1.ch5클래스.ex7;

public class Board {
	String title;
	String content;
	String writer;
	String password;
	int view;
	
	public Board() {}
	
	public Board(String title , String content , 
		         String writer ,String password , int view) {
		this.title=title;
		this.content=content;
		this.writer=writer;
		this.password=password;
		this.view=view;
	}
}
