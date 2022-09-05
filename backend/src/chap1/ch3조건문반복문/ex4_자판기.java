package chap1.ch3조건문반복문;

import java.util.Scanner;

public class ex4_자판기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int 콜라재고 = 10; int 환타재고 = 10; int 사이다재고 = 10;
		int 콜라구매수 = 0; int 환타구매수 = 0; int 사이다구매수 = 0;
		while(true) {
			System.out.println("-------[자판기]-----------");
			System.out.println("메뉴 : 1.콜라(300) 2.환타(400) 3.사이다(500) 4.결제");
			System.out.print("선택:"); int 메뉴선택 = scanner.nextInt();
			if(메뉴선택 == 1) {
				if(콜라재고>0) {
					콜라재고--; 콜라구매수++;
					System.err.println("안내)콜라를 장바구니에 담았습니다.");
				}
				else {
					System.err.println("안내 ) 콜라재고가 없습니다.");
				}
			} 
			else if(메뉴선택 == 2) {
				if(환타재고>0) {
					환타재고--; 환타구매수++;
					System.err.println("안내)환타를 장바구니에 담았습니다.");
				}
				else {
					System.err.println("안내 ) 환타재고가 없습니다.");
				}
			}
			else if(메뉴선택 == 3) {
				if(사이다재고>0) {
					사이다재고--; 사이다구매수++;
					System.err.println("안내)사이다를 장바구니에 담았습니다.");
				}
				else {
					System.err.println("안내 ) 사이다재고가 없습니다.");
				}
			}
			else if(메뉴선택 == 4) {
				System.out.println("==============장바구니=================");
				System.out.println("제품명\t구매수\t가격");
				if(콜라구매수>0) {System.out.println("콜라\t"+콜라구매수+"\t"+(콜라구매수*300));}
				if(환타구매수>0) {System.out.println("환타\t"+환타구매수+"\t"+(환타구매수*300));}
				if(사이다구매수>0) {System.out.println("사이다\t"+사이다구매수+"\t"+(사이다구매수*300));}
				int 총결제 = (콜라구매수*300)+(환타구매수*300)+(사이다구매수*300);
				//제품 갯수 차감메뉴
				
				System.err.println("안내)총 결제 예정금액:"+총결제+"원");
				System.out.println("=====================================");
				System.out.println("안내) 결제 하시겠습니까? [Y] [N] "); 
				String 결제여부 = scanner.next();
				boolean 결제성공 = false;
				if(결제여부.equals("y")||결제여부.equals("Y")) { 
					System.out.println("안내)결제금액을 투여해주세요 !"); int 투입금액 = scanner.nextInt();
					if(총결제>투입금액) {
						System.out.println("안내)금액이 부족합니다. [결제취소]");
						}
					else {
						결제성공=true;
						System.out.println("안내)구매 완료 번호:0000 [잔돈 : "+(투입금액-총결제)+"]");
						}		
				}
				if(결제성공==false){
					콜라재고+=콜라구매수; 환타재고+=환타구매수; 사이다재고+=사이다구매수;
				}
				콜라구매수=0; 환타구매수=0; 사이다구매수=0;			
			}
			else {System.err.println("다시 선택하세요.");}
		}				
	}
}
/*
 * 
 * 자판기 프로그램
 * 
 * 제품명: 콜라 환타 사이다
 * 초기재고 : 각 10개;
 * 메뉴판에서 선택한 제품을 장바구니에 담기
 * 결제를 선택했을때 장바구니 현황 표시 및 결제여부[돈 입력]
 * 투입금액이 부족-> 결제취소 투입금액 초과->잔돈출력
 * 
 * [화면구현]
 * 메뉴판 1.콜라 2환타 3사이다 4결제 5관리자
 * 
 * 갯수 오르고 내리게?
 * 관리자 메뉴? 비밀번호 입력 - > 재고 채울수있게 
 * 총매출금액
 * 
 * 
 * 
 */