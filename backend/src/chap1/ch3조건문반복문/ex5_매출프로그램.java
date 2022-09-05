package chap1.ch3조건문반복문;
import java.util.Scanner;
public class ex5_매출프로그램 {
	public static void main(String[] args) {
		 boolean run = true; 
         int balance = 0;
         Scanner scanner = new Scanner(System.in); 

         
         while( run ) {
            System.out.println("------------------------------");
            System.out.println("1. 예금 2. 출금 3. 잔고 4. 종료");
            System.out.println("------------------------------");
            System.out.println("선택> "); int ch = scanner.nextInt();
            if( ch == 1 ) {System.out.print("안내) 예금액>"); balance+= scanner.nextInt();} 
            else if( ch == 2 ) {
            	System.out.print("안내) 출금액>");
            	int money=scanner.nextInt();
            	if(balance<money) {System.err.println("안내)잔액이 부족합니다.");}
            	else {balance-=money;}
            	}
            else if( ch == 3 ) {System.out.println("안내) 잔고>"+balance);}
            else if( ch == 4 ) {break;}
            else{System.out.println("안내)알수없는 번호 입니다.");}
         	}
         System.out.println("프로그램 종료");  
		
		
		}
	}

