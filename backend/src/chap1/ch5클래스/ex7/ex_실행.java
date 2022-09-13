package chap1.ch5클래스.ex7;

import java.util.Scanner;

public class ex_실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board[] boardList = new Board[100];
		
		while(true) {
			System.out.println("=======================================================");
			System.out.println("번호\t작성자\t제목");
			
			int indexx = 0;
			for(Board temp : boardList) {
				indexx++;
				if(temp!=null) {
					System.out.printf("%d\t%s\t%s\n",indexx,temp.writer,temp.title);
				}
			}
			System.out.println("=======================================================");
			
			System.out.println("1)글쓰기 2)글보기 선택: "); int ch = sc.nextInt();
			
			if(ch==1) {
				System.out.print("제목 : ");		String title = sc.next();
				System.out.print("내용 : ");		String content = sc.next();
				System.out.print("작성자 : ");	String writer = sc.next();
				System.out.print("비밀번호 : ");	String password = sc.next();
				
				Board regist = new Board(title, content, writer, password, 0);
				
				for(int i = 0 ; i<boardList.length ; i++) {
					if(boardList[i]==null) {
						boardList[i]=regist;
						System.err.println("글 등록 !");
						break;
					}
				}
				
			}
			
			else if(ch==2) {	
				System.out.println("이동할 게시물 번호 : "); 
				int select = sc.nextInt();
				select--;
				Board br = boardList[select];
				System.out.println("--------------상세 페이지---------------");
				System.out.print("작성자 : " + br.writer);
				System.out.print("\t제목 : " + br.title);
				System.out.print("\t내용 : " + br.content + "\n");
				System.out.println("--------------------------------------");
				System.out.println("1)목록보기   2)삭제   3)수정  선택 :");    int ch2 = sc.nextInt();
				if(ch2==1) {
					
				}
				else if(ch2==2) {
					
					System.out.println("안내) 비밀번호 : "); 
					String delPw = sc.next();
					
					if(br.password.equals(delPw)) {
						boardList[select]=null;
						System.err.println("삭제 완료 !");
						
						for(int ii=0; ii<boardList.length ; ii++) {
							boardList[ii]=boardList[ii+1];
							
							if(boardList[ii+1]==null) {break;}
						}
					}
				}
				
				else if(ch2==3) {
					System.out.println("안내) 비밀번호 : "); 
					String delPw = sc.next();
					
					if(br.password.equals(delPw)) {
					System.out.print("작성자 수정 : ");  br.writer= sc.next();
					System.out.print("제목 수정 : ");	  br.title= sc.next();
					System.out.print("내용 수정: ");	  br.content= sc.next();
					}
				}
				else {System.out.println("잘못된 입력");}	
			}			
			else {System.out.println("잘못된 입력");}
		}
	}
}
