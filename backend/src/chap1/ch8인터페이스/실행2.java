package chap1.ch8인터페이스;

import java.util.Scanner;

public class 실행2 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		게임패드 gp;
		while(true) {
			System.out.println("1)축구 2)비행기게임 : ");
			int ch = sc.nextInt();
			if(ch==1) {
				gp = new 축구게임(); 게임실행(gp);
			}
			else if(ch==2) {
				gp = new 비행기게임(); 게임실행(gp);
			}
		}
	}
	
	public static void 게임실행(게임패드 gp) {
		while(true) {
			char 버튼 = sc.next().charAt(0);
			if(버튼=='A') {gp.A버튼();}
			if(버튼=='B') {gp.B버튼();}
			if(버튼=='C') {gp.C버튼();}
			if(버튼=='E') {return;}
		}
	}
}
