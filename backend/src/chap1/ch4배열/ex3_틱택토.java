package chap1.ch4배열;

import java.util.*;
import java.util.Scanner;

public class ex3_틱택토 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//게임판 생성
		String[] 게임판 = {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"};
		boolean win = true;
		int count = 0 ;
		
		while(win) {
			System.err.println("위치선택 하세요 ! \n");
			for(int i = 0 ; i<=8 ; i++) {
				System.out.printf(게임판[i]);
				if(i%3==2) {System.out.println();}
			}
			

			while(true) {
				int 사용자 = sc.nextInt();
				if(사용자<0 || 사용자>8) {System.out.println("재입력하세요");}
				if(게임판[사용자].equals("[ ]")) {게임판[사용자] = "[O]"; break;}
				else{System.out.println("이미 선택된 번호입니다.");}
			}
			

			while(true) {
				Random 컴퓨터 = new Random();
				int 랜덤 = 컴퓨터.nextInt(9);
				if(게임판[랜덤].equals("[ ]")) {게임판[랜덤] = "[X]"; break;}
			}
			
			
			for(int i = 0 ; i<=6 ; i+=3) { //가로 012 345 678
				if((!게임판[i].equals("[ ]")) && 게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2])) {
					System.out.println(게임판[i]+"승리");
					win = false;
				}
			}
			
			for(int i = 0 ; i<=2 ; i++) { //세로 036 147 258
				if((!게임판[i].equals("[ ]")) && 게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
					System.out.println(게임판[i]+"승리");
					win = false;
				}
			}
			
			if(!게임판[0].equals("[ ]")) { //대각선 048
				if(게임판[0].equals(게임판[4])) {
					if(게임판[4].equals(게임판[8])) {
						System.out.println(게임판[0]+"승리");
						win = false;
					}
				}
			}
			
			if(!게임판[2].equals("[ ]")) { //대각선 246
				if(게임판[2].equals(게임판[4])) {
					if(게임판[4].equals(게임판[6])) {
						System.out.println(게임판[2]+"승리");
						win = false;
					}
				}
			}
			
			count++;
			if(count==4) {
				System.out.println("무승부");
				win = false;
			}
			

		
			
			
			
			
			
			
			
		}		
	}
}


/*
[조건]
1.게임판 9칸-> 배열 0~8    String 배열 .equals

2.사용자가 위치[인덱스] 입력
	중복제거 
3.컴퓨터가 난수로 위치 입력 0~8
	중복제거
4.승리 판단   1가로 2세로 3대각선 4무승부
[] [] []
[] [] []
[] [] []








*/
