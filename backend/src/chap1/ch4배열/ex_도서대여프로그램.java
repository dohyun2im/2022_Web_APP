package chap1.ch4배열;

import java.util.Scanner;

public class ex_도서대여프로그램 {
	public static void main(String[] args) {
		String[][] members = new String[100][2];    members[99][0] = "admin";    members[99][1] ="1234";
		String[][] books = new String[100][3];	
		Scanner sc = new Scanner(System.in);
		
		int list = 0;
		boolean bookList = false;
		boolean program = true;
		
		while(program) {
			System.out.println("========도서 대여 Program===============");
			System.out.println("|번호|책이름        |대여가능| 아이디       | ");
			if(list%2==1) {bookList = true;}
			if(bookList) {
				for(int x=0 ; x<books.length; x++) {
					if(books[x][0]!=null) {
						System.out.print(x+"\t");
						System.out.print(books[x][0] +"\t\t");
						System.out.print(books[x][1] +"\t");
						System.out.print(books[x][2] +"\n");
					}
				}
			}
			System.out.println("======================================");
			System.out.print("1 ) . 회원가입     2 ) . 로그인   숫자입력:"); int select = sc.nextInt();
			
			
			if(select==1) {
				System.out.print("ID :");   String id  = sc.next();				
				boolean idCheck = true;		
				
				for(int row = 0 ; row<members.length ; row++) {
					if(members[row][0]!=null && members[row][0].equals(id)) {
						System.out.println("안내) 이미 있는 아이디입니다.");
						idCheck = false; break;
					}
				}
				
				if(idCheck) {
					System.out.print("password  :");	String password  = sc.next();
	
					for(int i=0 ; i<members.length; i++) {
						if(members[i][0] == null) {
							members[i][0] = id ; 
							members[i][1] = password ; 
						   System.out.println("회원가입 성공"); break;
						}
						if(i==99) {System.out.println("최대 회원 수 초과입니다.");}
					}
				}			
			}
			
						
			
			else if(select==2){
				System.out.print("LOGIN ID :"); String loginId  = sc.next();
				System.out.print("LOGIN PW :"); String loginPw  = sc.next();

				
				if(members[99][0].equals(loginId) && members[99][1].equals(loginPw)) {//관리자 로그인
					System.err.println("관리자 로그인");
						System.out.print("1)도서등록 2)목록띄우기 3)도서삭제 4)로그아웃 메뉴입력:"); int adminSel = sc.nextInt();	
						
						if(adminSel==1) {
							System.out.print("도서 등록하기 특수기호/띄움금지 :"); String register = sc.next();
							for(int x=0 ; x<books.length; x++) {
								if(books[x][0]==null) {
									books[x][0]=register;
									books[x][1]="O";
									books[x][2]="빌려가세요";
									break;
								}
							}
							while(true) {
								System.err.println("책 등록이 완료되었습니다 ! 추가입력 ? Yes(1) No(2)"); int adminYN = sc.nextInt();
								if(adminYN==1) {
									System.out.print("도서 등록하기 특수기호/띄움금지 :"); String register1 = sc.next();
									for(int x=0 ; x<books.length; x++) {
										if(books[x][0]==null) {
											books[x][0]=register1;
											books[x][1]="O";
											books[x][2]="빌려가세요";
											break;
										}
									}	
								}
								else if(adminYN==2) {break;}
								else {System.out.println("재입력 하세요 !");}
							}
						}
						
						
						else if(adminSel==2) {
							list++;
						}
						
						
						else if(adminSel==3) {
							System.out.print("삭제시킬 책 번호 입력해주세요 ! ( 입력:"); int bookN = sc.nextInt();
							System.out.print("삭제시킬 책 이름 입력해주세요 ! ( 입력:"); String book = sc.next();
	
							if(books[bookN][0].equals(book)) {
								books[bookN][0]=null;
								books[bookN][1]=null;
								books[bookN][2]=null;
							}
							for(int y=bookN ; y<books.length; y++) {
								books[y][0]=books[y+1][0];
								books[y][1]=books[y+1][1];
								books[y][2]=books[y+1][2];
								if(books[y+1][0]==null) {break;}
							}	
							System.out.println("삭제가 완료되었습니다 ! ");
						}
						
						else if(adminSel==4) {
							System.err.println("관리자 로그아웃");
						}
						
						else {System.err.println("숫자 재입력하세요.");}
				
				}
/*=============================================admin end=========================================================*/				
				
				else {//일반회원 로그인
					for(int i = 0 ; i<members.length ; i++) {
						if(members[i][0].equals(loginId) && members[i][1].equals(loginPw)) {
							System.out.println("로그인 완료 !");
								System.out.print("1)도서검색 2)도서목록 3)도서대여 4)도서반납 5)로그아웃 메뉴입력:"); int menuSel = sc.nextInt();
								if(menuSel==1) {
									System.out.print("찾고 싶은 책의 이름을 아나요? Yes(1) / 책의 번호를 아나요? Yes(2)"); int findYN = sc.nextInt();
									if(findYN==1) {
										System.out.println("찾고 싶은 책 이름은?"); String findBook = sc.next();
										for(int q = 0 ; q <books.length ; q++) {
											if(books[q][0].equals(findBook)) {
												System.out.print(books[q][0]);
												System.out.print(books[q][1]);
												System.out.print(books[q][2]);
											}
										}
									}
									else if(findYN==2) {
										System.out.println("찾고 싶은 책 번호는?"); int findN = sc.nextInt();
										System.out.println("책의 이름 : "+books[findN][0]); break;
									}
									else {System.err.println("숫자를 다시 입력하세요");}
								}
								
								
								else if(menuSel==2){
									System.err.print("도서목록이 안보이나요 ? yes(1) No(2)"); int listYN = sc.nextInt();
									if(listYN==1) {
										list++;
									}
									else if(listYN==2) {
										System.err.println("초기 화면으로 .. ");
									}
									else {System.err.println("숫자를 다시 입력하세요");}
								}
								
								
								else if(menuSel==3){
									
								}
								
								
								else if(menuSel==4){
									
								}
								
								
								else if(menuSel==5){
									System.err.println("로그아웃 합니다."); break;
								}
								
								
								else {System.err.println("숫자를 다시 입력하세요.");}
								
						}
						else{
								System.err.println("=========================");
								System.err.println("재입력 ! 초기화면으로 돌아갑니다");
								System.err.println("========================="); 
						}
					}
					
				}		
			}			
			else {System.err.println("숫자를 다시 입력하세요.");}		
		}
	}	
}

/*
   도서 대여 console 프로그램
   1. 배열 변수
      1. 회원 [ 아이디(중복x) , 비밀번호 ]
      2. 도서 [ 도서명(중복x) , 도서대여여부(대여가능,대여중) , 대여인(로그인시 아이디) ]
   2. 초기메뉴
      1.회원가입 2.로그인 
         1.회원가입시 아이디 중복체크 
         2.로그인 성공시 로그인메뉴 , 로그인 실패시 로그인실패 출력 
   3. 로그인시 메뉴 
      1. 도서검색 2.도서목록 3.도서대여 4.도서반납 5.로그아웃
          1. 도서검색시 도서명이 일치하면 도서명과 도서대여여부 출력
         2. 도서목록시 모든 도서명 출력 
         3. 도서대여시 도서대여여부가 가능할때 도서대여 처리
         4. 도서반납시 본인이 대여한 도서만 반납 처리 
         5. 로그아웃 초기메뉴로 
   4. 로그인시 아이디가 admin 이면 관리자메뉴 
      1. 도서등록 2.도서목록 3.도서삭제(도전) 4.로그아웃
         1. 도서등록시 도서명을 입력받아 도서 등록처리
         2. 도서목록시 모든 도서명 출력 
         3. 도서삭제시 삭제할 도서명을 입력받아 동일한 도서명 삭제[ null ]
         4. 로그아웃시 초기메뉴로 
 */
