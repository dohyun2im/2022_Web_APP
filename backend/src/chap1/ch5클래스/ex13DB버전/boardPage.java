package chap1.ch5클래스.ex13DB버전;

import java.util.Scanner;

public class boardPage {
	Scanner sc = new Scanner(System.in);
	boardControl control = new boardControl();
	
	
	public static void main(String[] args) {
		boardPage page = new boardPage();
		page.view();
	}
	
	
	
	void view() {
		boardPage page = new boardPage();
		while(true) {
			page.getBoardlist();
			System.out.println("1.글쓰기 2.글제목 선택:");
			int btn = sc.nextInt();
			if(btn==1) {page.regist();}
			else if(btn==2) {page.getBoard();}
			else {System.out.println("알수없는 번호입니다.");}
		}
	}
	
	//1.등록
	void regist() {
		System.out.println("등록 페이지");
		System.out.print(">>제목:"); 	String b_title = sc.nextLine();
		System.out.print(">>내용:");	String b_content = sc.nextLine();
		System.out.print(">>작성자:");	String b_writer = sc.next();
		System.out.print(">>비밀번호:");String b_password = sc.next();
		sc.nextLine();
		
		boolean result = control.regist(b_title, b_content, b_writer, b_password);
		if(result==true) {System.out.println("게시물 등록 성공");}
		else {System.err.println("게시물 등록 실패");}
	}
	
	//2.전체페이지
	void getBoardlist() {
		System.out.println("=====게시판=========");
		System.out.println("번호\t작성자\t제목\t조회수");
		boardDto[] boardlist = control.getBoardlist();
		for(boardDto dto : boardlist) {
			System.out.print(dto.b_num+"\t");
			System.out.print(dto.b_writer+"\t");
			System.out.print(dto.b_title+"\t");
			System.out.print(dto.b_view+"\n");
		}
	}
	
	//3.상세페이지
	void getBoard() {
		boardPage page = new boardPage();
		
		System.out.print("게시물 번호를 입력하세요"); int b_num = sc.nextInt();
		boardDto board = control.getBoard(b_num);
			if(board==null) {
				System.out.println("없는 번호입니다."); return;
			}
		System.out.println("===>>개별조회 페이지");
		System.out.print("제목:"+board.b_title+"\t");
		System.out.print("작성자:"+board.b_writer+"\t");
		System.out.print("조회수:"+board.b_view+"\n");
		System.out.print("내용:"+board.b_content+"\n");
		System.out.print("1.뒤로가기 2.수정 3.삭제  :  ");
		int btn = sc.nextInt();
		if(btn==1) {return;}
		else if(btn==2) {page.update(b_num);}
		else if(btn==3) {page.delete(b_num);}
		else {System.out.println("잘못된 입력입니다");}
	}
	
	//4.수정
	void update (int b_num) {
		System.out.println("===>>수정처리 페이지");
	}
	
	//5.삭제
	void delete(int b_num) {
		System.out.println("===>>삭제처리 페이지");
	}	
}
