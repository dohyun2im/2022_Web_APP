package chap1.ch4배열;
import java.util.Scanner;

public class ex7_비회원제게시판 {
	public static void main(String[] args) {
		String[][] board = new String[100][4];	
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("====================== 회원제 페이지 ====================");
			System.out.println("번호)   작성자)    제목)");
			for(int i=0; i<board.length; i++) {
				if(board[i][0]!=null) {
					System.out.print(i+"\t");
					System.out.print(board[i][2]+"\t");
					System.out.print(board[i][0] +"\n");
				}
			}
			System.out.print("메뉴) 1.(글쓰기)  2.(글보기)");
			System.out.print("선택 : "); int btn = sc.nextInt();
			
			
			
			if(btn==1) {
				
				System.out.print("writer :");	 	String writer  = sc.next();
				boolean writerCheck = true;		
				
				for(int row = 0 ; row<board.length ; row++) {
					if(board[row][2]!=null && board[row][2].equals(writer)) {
						System.out.println("안내) 이미 작성자님께서 작성하셨습니다.");
						writerCheck = false; 
								      break;
					}
				}
				
				if(writerCheck) {
					System.out.print("title :");	 	String title  = sc.next();
					System.out.print("content :");		String content  = sc.next();
					System.out.print("password  :");	String password  = sc.next();
				
					for(int row=0 ; row<board.length; row++) {
						if(board[row][0] == null) {
							board[row][0] = title ; 
							board[row][1] = content ; 
							board[row][2] = writer ; 
							board[row][3] = password ;
							
						   System.out.println("글쓰기 성공");
						   break; //저장하고 break;
						}
						if(row==99) {System.out.println("최대 게시물 수 입니다.");}
					}
				}
			}
			
			
/*===============================완료=====================================*/
			
			
			else if(btn==2) {
				System.out.println("============================================");
				System.out.print("1.목록보기 2.글삭제 3.글수정 선택:"); int btn2 = sc.nextInt();
				
				if(btn2==1) {
					System.out.print("보실 페이지를 선택하세요."); int select = sc.nextInt();
					System.out.println("========== 상세 페이지 ============");
					System.out.println("번호 :" +select);
					System.out.println("작성자 :" +board[select][2]);
					System.out.println("제목 :" +board[select][0]);
					System.out.println("내용 :" +board[select][1]);
				}
				
				else if(btn2==2) {
					System.out.print("삭제할 게시물 번호를 입력하세요 입력:"); 	  int btn3 = sc.nextInt();
					System.out.print("삭제할 게시물 비밀번호를 입력하세요 입력:"); String pww = sc.next();
					if(board[btn3][3].equals(pww)) {
						board[btn3][0] = null ; 
						board[btn3][1] = null ; 
						board[btn3][2] = null ; 
						board[btn3][3] = null ;
						for(int j = btn3 ; j<board.length ; j++) {
							board[j][0] =board[j+1][0];
							board[j][1] =board[j+1][1];
							board[j][2] =board[j+1][2];
							board[j][3] =board[j+1][3];
							if(board[j+1][0]==null) {break;}
						}
					}
					else {System.err.println("비밀번호가 틀렸습니다.");}					
				}
				
				
				else if(btn2==3) {
					
					System.out.print("수정할 게시물 번호를 입력하세요 입력:"); int btn4 = sc.nextInt();
					System.out.print("수정할 게시물 비밀번호를 입력하세요 입력:"); String pwww = sc.next();
					if(board[btn4][3].equals(pwww)) {
						System.out.println("작성자 :"+board[btn4][2]);
						System.out.println("제목 : "+board[btn4][0]);
						System.out.println("내용 : "+board[btn4][1]);
						System.out.print("제목-> "+board[btn4][0]+"의 수정사항 :"); String revise1 = sc.next();
						board[btn4][0]=revise1;
						System.out.print("내용-> "+board[btn4][1]+"의 수정사항 :"); String revise2 = sc.next();
						board[btn4][1]=revise2;
						System.out.println("수정완료");
						System.out.println(board[btn4][0]);
						System.out.println(board[btn4][1]);	
					}
				}				
				else {System.err.println("숫자를 다시 입력하세요.");}
			}
					
			else {System.err.println("숫자를 다시 입력하세요.");}			
		}
	}
}
