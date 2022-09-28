package chap1.키오스크.관리자;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
	Scanner sc =new Scanner(System.in);
	admincontroller ac = new admincontroller();
	public static void main(String[] args) {
		AdminView admin = new AdminView();
		admin.menu();
	}
	
	void menu() {
		while(true) {
			System.out.println("1)메뉴추가 2)제품추가 3)주문확인");
			try {
				int ch = sc.nextInt();
				if(ch==1) {inMenu();}
				else if(ch==2){inProduct();}
				else if(ch==3){getOrder();}
				else{System.out.println("알 수 없는 번호입니다.");}
			} 
			catch (Exception e) {
				System.out.println("선택할 수 없는 작동");
				sc =new Scanner(System.in);
			}		
		}
	}
	
	
	void inMenu() {
		System.out.println("추가할 메뉴 이름 ?");
		String mname = sc.next();
		boolean result = ac.inMenu(mname);
		if(result) {System.out.println("메뉴 등록 성공");}
		else {System.err.println("메뉴 등록 실패");}
		}
	
	
	void inProduct() {
		ArrayList<MenuDto> list =ac.getMenu();
		for(MenuDto menu : list) {
			System.out.print(menu.getMno()+"\t");
			System.out.print(menu.getMname()+"\n");
		}
		System.out.print("카테고리 번호: "); int mno = sc.nextInt();
		System.out.print("제품명 :");  String pname = sc.next();
		System.out.print("가격 :");	int pprice = sc.nextInt();
		System.out.print("소개 :");	String pcomment = sc.next();
		System.out.print("재고 :");	int pamount = sc.nextInt();

		boolean result = ac.inProduct(mno,pname, pprice, pcomment, pamount);

		if(result) {System.out.println("메뉴 등록 완료");}
		else {System.out.println("메뉴 등록 실패");}
		}
	
	
	
	void getOrder() {
		ac.getOrder();
	}
	
}
