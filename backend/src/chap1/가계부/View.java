package chap1.가계부;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import chap1.키오스크.관리자.MenuDto;

public class View {
	Scanner sc =new Scanner(System.in);
	Controller ct = new Controller();
	int page = 0;
	public static void main(String[] args) {
		View V = new View();
		V.Menu();
	}
	
	void Menu() {
		while(true) {
			ArrayList<Dto> list =ct.getMenu(page);
			System.out.println("=================="+(page/3+1)+"page====================");
			for(Dto menu : list) {
				System.out.print(menu.getM_num()+"\t");
				System.out.print(menu.getM_date()+"\t");
				System.out.print(menu.getPrice()+"\t");
				System.out.print(menu.getContent()+"\n");
			}
			System.out.println("============================================");
			System.out.println("1)추가 2)삭제 3)수정 4)검색 5)통계 6)다음페이지 7)전페이지");
			try {
				int ch= sc.nextInt();
				if(ch==1) {inMenu();}
				else if(ch==2) {delMenu();}
				else if(ch==3) {updateMenu();}
				else if(ch==4) {searchMenu();}
				else if(ch==5) {statistics();}
				else if(ch==6) {page+=3;}
				else if(ch==7) {page-=3;}
				else {System.err.println("재입력");}
			} 
			catch (Exception e) {
				System.out.println("오작동");
				sc =new Scanner(System.in);
			}	
		}
	}
	
	
	void inMenu() {
		System.out.print("날짜? yyyy-mm-dd :");  String date = sc.next();
		System.out.print("사용금액 ? :");	    	int price = sc.nextInt();
		System.out.print("사용내용 ? :");		    String content = sc.next();
		boolean result = ct.inMenu(date, price, content);
		if(result) {System.out.println("가계부 등록 성공");}
		else {System.err.println("가계부 등록 실패");}
	}
	
	
	void delMenu() {
		System.out.print("지울번호 ? :");	    	int M_num = sc.nextInt();
		boolean result = ct.delMenu(M_num);
		if(result) {System.out.println("가계부 삭제 성공");}
		else {System.err.println("가계부 삭제 실패");}
	}
	
	
	void updateMenu() {
		System.out.print("수정번호 ? :");	    	int M_num = sc.nextInt();
		System.out.print("날짜? yyyy-mm-dd :");  String date = sc.next();
		System.out.print("사용금액 ? :");	    	int price = sc.nextInt();
		System.out.print("사용내용 ? :");		    String content = sc.next();
		boolean result = ct.updateMenu(M_num,date,price,content);
		if(result) {System.out.println("가계부 수정 성공");}
		else {System.err.println("가계부 수정 실패");}
	}
	
	
	
	void searchMenu() {
		try {
			System.out.println("날짜 입력 : "); String date = sc.next();
			ArrayList<Dto> list =ct.searchdate(date);
			System.out.println("=====================================");
			for(Dto menu : list) {
				System.out.print(menu.getM_num()+"\t");
				System.out.print(menu.getM_date()+"\t");
				System.out.print(menu.getPrice()+"\t");
				System.out.print(menu.getContent()+"\n");
			}
			System.out.println("=====================================");
		} 
		catch (Exception e) {
			System.out.println("오작동");
			sc =new Scanner(System.in);
		}		
	}
	
	
	void statistics() {
		try {
			ArrayList<Dto> list =ct.statistics();
			System.out.println("===============통계====================");
			for(Dto menu : list) {
				System.out.print(menu.getM_date()+"\t");
				System.out.print(menu.getPrice()+"\n");
			}
			System.out.println("======================================");
		} 
		catch (Exception e) {
			System.out.println("오작동");
			sc =new Scanner(System.in);
		}	
	}
}
