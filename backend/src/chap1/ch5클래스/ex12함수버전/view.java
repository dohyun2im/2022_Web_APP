package chap1.ch5클래스.ex12함수버전;

import java.util.Scanner;

public class view {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		start();
		
	}
	
	//시작
	static void start() {
		while(true) {
			view_boardList();
			System.out.println("--------------비회원 게시판----------------");
			System.out.println("1) 글쓰기    2) 글보기       입력:");
			int ch = sc.nextInt();
			if(ch==1) {view_regist();}
			else if(ch==2) {view_board();}
			else {}
			
		}
	}
	
	//등록
	static void view_regist() {
		System.out.println(">>>>>>>게시물 등록 페이지");
		System.out.print("제목 :"); 		String title = sc.next();
		System.out.print("내용 :");		String content = sc.next();
		System.out.print("작성자 :");		String writer = sc.next();
		System.out.print("비밀번호 :");	String password = sc.next();
		boolean result = 
				controller.con_regist( title , content , writer , password );
		if( result ) {
			System.err.println("안내) 게시물 등록 완료 ");
		}else {
			System.err.println("안내) 게시물 실패 [ 관리자에게 문의 ] ");
		}
	}
	
	//상세
	static void view_board() {
		System.out.println("게시물번호 선택 : "); int bNum = sc.nextInt();
		System.out.println(">>>>>>>게시물 상세 페이지");
		board temp = controller.boardlist[bNum];
		if(temp==null) {System.out.println("안내) 없는 게시물 번호입니다"); return;}
		System.out.println("제목 : "+temp.title);
		System.out.println("작성자 : "+temp.writer);
		System.out.println("내용 : "+temp.content);
		System.out.println("1)뒤로가기   2)수정    3)삭제"); int ch = sc.nextInt();
		if(ch==1) {}
		else if(ch==2) {view_update(bNum);}
		else if(ch==3) {view_delete(bNum);}
		else {}
		return;
	}
	
	
	//삭제
	static void view_delete(int bNum) {
		System.out.print("삭제할 게시물 비밀번호를 입력하세요 입력:"); 
		String password = sc.next();
		boolean result = controller.con_delete(bNum, password);
		if(result) {System.out.println("삭제 성공");}
		else {System.out.println("삭제 실패");}
	}
	
	
	
	
	
	//수정
	static void view_update(int bNum) {
		System.out.print("수정할 게시물 비밀번호를 입력하세요 입력:"); 
		String password = sc.next();
		System.out.print("수정할 제목: "); String title = sc.next();
		System.out.print("수정할 내용: "); String content = sc.next();	
		boolean result = 
				controller.con_update(bNum , password , title , content);
		if(result) {System.out.println("게시물 수정 성공");}
		else {System.out.println("게시물 수정 실패");}
	}
	
	
	//전체 페이지
	static void view_boardList() {
		System.out.println("------------게시물 목록 페이지--------------");
		System.out.println("번호\t\t작성자\t\t제목");
		for(int i =0; i<controller.boardlist.length ; i++) {
			board temp = controller.boardlist[i];
			if(temp!=null){
				System.out.print(i+"\t\t");
				System.out.print(temp.writer+"\t\t");
				System.out.print(temp.title+"\t\t\n");
			}
		}		
	}
	
	
}
