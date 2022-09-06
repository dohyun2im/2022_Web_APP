package chap1.ch4배열;

import java.util.Scanner;

public class ex6_회원 {
	public static void main(String[] args) {
		String[][] memberList = new String[100][4];
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true){ //종료안함;
			System.out.println("====================== 회원제 페이지 ====================");
			System.out.println("메뉴) 1.(로그인)  2.(회원가입)  3.(아이디찾기)  4.(비밀번호찾기)");
			System.out.println("======================================================");
			System.out.print("선택 : "); int btn = sc.nextInt();
			
			
			if(btn==1) {
				System.out.println("======================== 로그인   ======================");
				System.out.print("로그인 아이디 :");	 	String loginId = sc.next();
				System.out.print("로그인 비밀번호 :");		String loginPw = sc.next();
				byte login = 0 ;
				for(int i = 0 ; i<memberList.length ; i++) {
					if(memberList[i][0]!=null && memberList[i][0].equals(loginId)) {
						login=2;
						if(memberList[i][1].equals(loginPw)){
							System.out.println("로그인 성공"); 
							login=1; 
							while(true) {
								System.out.println("회원 메뉴) 1.회원탈퇴 2.로그아웃");
								int btn2 = sc.nextInt();
								
								if(btn2==1) {
									System.out.println("안내) 회원탈퇴가 되었습니다.");
									memberList[i][0] = null;
									memberList[i][1] = null;
									memberList[i][2] = null;
									memberList[i][3] = null; //지운곳을 한칸씩 땡겨야함;
									for(int j = i ; j<memberList.length ; j++) {
										memberList[j][0] =memberList[j+1][0];
										memberList[j][1] =memberList[j+1][1];
										memberList[j][2] =memberList[j+1][2];
										memberList[j][3] =memberList[j+1][3];
										if(memberList[j  +1][0]==null) {break;}
									}
									break;
								}
								else if(btn2==2) {
									break;
								}
							}
							
							break;
						}						
					}
				}
				
				if(login==0) {System.out.println("안내)동일한 아이디가 없습니다.");}
				else if(login==2) {System.out.println("안내) 비밀번호가 일치하지 않습니다.");}
				else if(login==1) {System.out.println("안내) 로그아웃 되었습니다.");}
				
			}
			
			
			else if(btn==2) {
				System.out.println("====================== 회원   가입   ====================");
				System.out.print("아이디 :");	 	String id = sc.next();	
				//아이디 중복체크
				boolean idCheck = true;
				for(int row = 0 ; row<memberList.length ; row++) {
					if(memberList[row][0]!=null && memberList[row][0].equals(id)) {
						System.out.println("안내) 이미 사용중인 아이디입니다.");
						idCheck = false; 
								  break;
					}
				}
				if(idCheck) {
					System.out.print("비밀번호 :");	String pw = sc.next();
					System.out.print("이름 :");		String name = sc.next();
					System.out.print("전화번호 :");	String pn = sc.next();
				
					//배열에 저장 -> 배열내 빈행을 찾는다.
					for(int row=0 ; row<memberList.length; row++) {
						if(memberList[row][0] == null) {
						   memberList[row][0] = id ; 
						   memberList[row][1] = pw ; 
						   memberList[row][2] = name ; 
						   memberList[row][3] = pn ;
						   System.out.println("회원가입 성공");
						   break; //저장하고 break;
						}
						if(row==99) {System.out.println("최대회원 수 입니다.");}
					}
				}
				
			}
			
			
			
			
			else if(btn==3) {
				
				System.out.println("============== 아이디 찾기 =====================");
				System.out.print("이름 :");	 	String findName = sc.next();
				System.out.print("전화번호: :");		String findPn = sc.next();

				for(int i = 0 ; i<memberList.length ; i++) {
					if(memberList[i][0]!=null && 
					   memberList[i][2].equals(findName) && 
					   memberList[i][3].equals(findPn)) {
							System.out.println("아이디 : " +memberList[i][0]);
							break;									
					}
					if(i==memberList.length-1) {
						System.out.println("안내) 동일한 회원정보가 없습니다.");
					}
				}
			}
			
			
			
			
			
			else if(btn==4) {			
				System.out.println("============== 비밀번호 찾기 =====================");
				System.out.print("아이디 :");	 	String findId = sc.next();
				System.out.print("전화번호: :");		String findPn = sc.next();
				
				for(int i = 0 ; i<memberList.length ; i++) {
					if(memberList[i][0]!=null && 
					   memberList[i][0].equals(findId) && 
					   memberList[i][3].equals(findPn)) {
							System.out.println("비밀번호 : " +memberList[i][1]);
							break;								
					}
					if(i==memberList.length-1) {
						System.out.println("안내) 동일한 회원정보가 없습니다.");
					}
				}				
			}
			
						
			else {System.err.println("재입력 하세요.");}	
		}
	}
}
/*
 [출력]
 1.메뉴  회원가입 로그인 아이디찾기 비밀번호찾기
 
 1.회원가입 기능 : 아이디 비밀번호 이름 전화번호
   ㄴ 배열내 빈 공간을 찾아 인덱스에 넣어줌 ;  null / 0 / 0.0 /false;
   ㄴ 아이디 중복체크 
   ㄴ 최대회원 100명 총 400개 변수 -> 2차원 배열 !
   ㄴ 행당 1명
   ㄴ 0아이디 1비번 2이름 3전번
   ㄴ 
 
 2.로그인 : 아이디 비밀번호가 동일하면 성공
 
 3.아이디찾기 : 
 	ㄴ 이름과 전화번호가 동일하면 아이디 알려주기
 
 4.비밀번호찾기 : 
 	ㄴ 아이디 전화번호가 동일하면 비밀번호 알려주기



*/