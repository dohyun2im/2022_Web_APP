package chap1.ch13컬렉션프레임워크;

import java.util.Vector;

public class vector {
	public static void main(String[] args) {
		
		Vector<Board> list = new Vector<>();
		list.add(new Board("제목1","내용1","글쓴이1"));
		list.add(new Board("제목2","내용2","글쓴이2"));
		list.add(new Board("제목3","내용3","글쓴이3"));
		list.add(new Board("제목4","내용4","글쓴이4"));
		list.add(new Board("제목5","내용5","글쓴이5"));
		for(Board b : list) {
			System.out.print(b.subject+"\t");
			System.out.print(b.content+"\t");
			System.out.print(b.writer+"\n");
		}
		
		list.remove(2); //3
		list.remove(3); //5  
		for(Board b : list) {
			System.out.print(b.subject+"\t");
			System.out.print(b.content+"\t");
			System.out.print(b.writer+"\n");
		}
	}
}
