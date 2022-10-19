package java1.d배열;

import java.util.Scanner;

public class jj {
	
	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
		 String[][] list = new String[100][4];//100개의 게시물을 담을 수 있는 4개의 열/ 2차원 배열
		 
			
		while(true) {//while시작	
			
			System.out.println("===1.글쓰기===2.글보기===");
			System.out.println("선택:");				
				
			int btn= scanner.nextInt();	
			
			if(btn==1) {			
				for(int i=0; i<list.length; i++) {
					if(list[i][0]==null) {//list 값이 없을 때
					System.out.println("==============글쓰기페이지==============");
					System.out.println("이름을 입력하세요"); String name = scanner.next();		//이름 입력공간
					System.out.println("제목을 입력하세요"); String title = scanner.next();		//제목 입력공간
					System.out.println("내용을 입력해 주세요"); String content = scanner.next();	//내용 입력공간
					System.out.println("비밀번호를 입력하세요"); String password = scanner.next();	//비밀번호 입력공간				
						list[i][0]=title; list[i][1]=name;
						list[i][2]=password; list[i][3] = content;					
						System.out.println("안내)입력이 완료 되었습니다 \n 글보기 페이지로 이동해 주세요.");	
						break;
					}//if end
				}//for end			
			}//if end
			
			
			else if(btn==2) {//글보기페이지
				
				System.out.println("==============비회원페이지==============");//
				System.out.println("번호\t 이름\t 제목\t 내용\t"); 
				
				for(int i=0; i<list.length; i++) { //비회원 페이지에 출력 되는 페이지
					if(list[i][0]!=null) { //만약에 list의 [0]번째행에 값이 없으면
						System.out.print(i+"\t");//번호 출력 이미 for문으로 ++을 했기 때문에 출력할때마다 1씩증가함
						System.out.print(list[i][1]+"\t");//list의 index 1번인 name이 출력 
						System.out.print(list[i][0]+"\t");//list의 index 0번인 title출력			
						System.out.print(list[i][3]+"\n");//list의 index 3번인 content출력
					}//if end
				}//for end
							
				System.out.println("==============비회원 메뉴==============");
				System.out.println("==1.뒤로가기==2.글삭제하기==3.글수정하기==");
				
				int 비회원메뉴 = scanner.nextInt();
							
				if(비회원메뉴==1) {//뒤로가기
					System.out.println("비회원 메뉴로 이동합니다.");				
				}//뒤로가기 end
				
				else if(비회원메뉴==2) {
					System.out.println("삭제 할 번호를 입력해 주세요.");//삭제 할 번호일 입력받아
										
				
					int 삭제번호 = scanner.nextInt();
					/*String 비밀번호확인 =list[i][2]; */
					
					
					
					 
					  
					  String 비밀번호 = scanner.next();//비밀호가 맞는지 입력할 상자 scanner.nextInt(비밀번호);
					  
		
					   
					  if(list[삭제번호][2].equals(비밀번호)) { list[삭제번호][0] = null; list[삭제번호][1] = null;
					  list[삭제번호][2] = null; list[삭제번호][3] = null; }
					  else { System.out.println("비밀번호가 올바르지 않습니다. 다시 입력해주세요."); }
				
												
				}//else if end
				
				
				else if(비회원메뉴==3) {
					System.out.println("==============수정하기==============");
					
		
					System.out.println("수정 할 번호를 입력해 주세요.");//삭제 할 번호일 입력받아
					
					
					int 삭제번호 = scanner.nextInt();
					
					 
					
					
					
					 
					  System.out.println("비밀번호를 입력해주세요.");
					  String 비밀번호 = scanner.next();//비밀호가 맞는지 입력할 상자 scanner.nextInt(비밀번호);
					  
		
					   
					  if(list[삭제번호][2].equals(비밀번호)) { 
						  
						 System.out.println("수정할 내용을 입력해주세요."); String 수정할내용 = scanner.next();
						 System.out.println("수정할 제복을 입력해주세요.");String 수정할제목 = scanner.next();					  
						  
						 list[삭제번호][3] = 수정할내용;
						 list[삭제번호][0] = 수정할제목;
						 
					  }
					  
					  else { System.out.println("비밀번호가 올바르지 않습니다. 다시 입력해주세요."); }
					
				}//(수정)
			

			
			else if(btn==3) {}			
			else {
				System.err.println("안내)올바르지않은 번호 입니다. 다시 입력해주세요.");
			}
		
		}//while end
	
		
	}//main end
}//class end

}
/*
 console 화면에
 ===1.글쓰기===2.글보기=== 출력
 
 1)배열 생성
 -최대100명까지 4개의 행을 출력 [100][4]
 
2)입력받기
	 1.글쓰기 페이지
		1)이름,제목,내용,비밀번호를 받는다
		입력받은 내용들을 배열에 각각 저장한다.
		
	  
	  
3)입력받은 내용을 글보기 페이지로 출력 
	1)뒤로가기
	2)삭제하기
		1.삭제 할 번호를 입력받아
		2.비밀번호를 입력한다. 비밀번호가 일치하면 삭제되었습니다. 그렇지 않으면 올바르지 않은 번호입니다
	3)수정하기
		1.수정 할 번호를 입력받는다
		2.비밀번호를 입력받는다
		3.수정을 한다.
		4.수정한 내용을 변경한다.
 */
