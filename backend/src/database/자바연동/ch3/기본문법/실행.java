package database.자바연동.ch3.기본문법;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			for(int i=1; i<20 ; i++) {
				System.out.println(i+"번째 출력입니다.");
				System.out.println("예제번호 입력");
				
				int ch = sc.nextInt();
				
				DAO dao = new DAO();
				
				if(ch==1) {
					ArrayList<DTO> list = dao.예제1결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.mem_number+"\t");
						System.out.print(DTO.addr+"\t");
						System.out.print(DTO.phone1+"\t");
						System.out.print(DTO.phone2+"\t");
						System.out.print(DTO.height+"\t");
						System.out.print(DTO.debut_date+"\n");
					}
				}
				
				else if(ch==2) {
					ArrayList<String> list = dao.예제2결과();
					for(String s : list) {
						System.out.print(s+"\t");
					}
					System.out.println();
				}
			
				else if(ch==3) {
					DTO DTO = dao.예제3결과();
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.mem_number+"\t");
						System.out.print(DTO.addr+"\t");
						System.out.print(DTO.phone1+"\t");
						System.out.print(DTO.phone2+"\t");
						System.out.print(DTO.height+"\t");
						System.out.print(DTO.debut_date+"\n");	
				}
				
				else if(ch==4) {
					ArrayList<DTO> list = dao.예제4결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\n");
					}
				}
				
				else if(ch==5) {
					ArrayList<DTO> list = dao.예제5결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.height+"\t");
						System.out.print(DTO.mem_number+"\n");
					}
				}
				
				else if(ch==6) {
					ArrayList<DTO> list = dao.예제6결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.height+"\t");
						System.out.print(DTO.mem_number+"\n");
					}
				}
				
				else if(ch==7) {
					ArrayList<DTO> list = dao.예제7결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.mem_number+"\t");
						System.out.print(DTO.addr+"\t");
						System.out.print(DTO.phone1+"\t");
						System.out.print(DTO.phone2+"\t");
						System.out.print(DTO.height+"\t");
						System.out.print(DTO.debut_date+"\n");
					}
				}
				
				else if(ch==8) {
					ArrayList<DTO> list = dao.예제8결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.mem_number+"\t");
						System.out.print(DTO.addr+"\t");
						System.out.print(DTO.phone1+"\t");
						System.out.print(DTO.phone2+"\t");
						System.out.print(DTO.height+"\t");
						System.out.print(DTO.debut_date+"\n");
					}
				}
				
				else if(ch==9) {
					ArrayList<DTO> list = dao.예제9결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.debut_date+"\n");
					}
				}
				
				else if(ch==10) {
					ArrayList<DTO> list = dao.예제10결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.debut_date+"\t");
						System.out.print(DTO.height+"\n");
					}
				}
				
				else if(ch==11) {
					ArrayList<DTO> list = dao.예제11결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.debut_date+"\t");
						System.out.print(DTO.height+"\n");
					}
				}
				
				else if(ch==12) {
					ArrayList<DTO> list = dao.예제12결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_name+"\t");
						System.out.print(DTO.height+"\n");
					}
				}
				
				else if(ch==13) {
					ArrayList<String> list = dao.예제13결과();
					for(String s : list) {
						System.out.print(s+"\t");
					}
					System.out.println();
				}
				
				else if(ch==14) {
					ArrayList<DTO> list = dao.예제14결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.sum+"\n");
					}
				}
				
				else if(ch==15) {
					ArrayList<DTO> list = dao.예제15결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.sum+"\n");
					}
				}
				
				else if(ch==16) {
					ArrayList<DTO> list = dao.예제16결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.sum+"\n");
					}
				}
				
				else if(ch==17) {
					ArrayList<DTO> list = dao.예제17결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.sum+"\n");
					}
				}
				
				else if(ch==18) {
					ArrayList<DTO> list = dao.예제18결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.sum+"\n");
					}
				}
				
				else if(ch==19) {
					ArrayList<DTO> list = dao.예제19결과();
					for(DTO DTO : list) {
						System.out.print(DTO.mem_id+"\t");
						System.out.print(DTO.sum+"\n");
					}
				}
				
				else {System.out.println("재입력");}
				
			}
		}
	}
}
