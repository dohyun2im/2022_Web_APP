package chap1.ch4배열;

import java.util.Random;
import java.util.Scanner;

public class ex2_로또 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int[] 구매번호 = new int[6];
	int[] 추첨번호 = new int[6];
	
	for(int i = 0 ; i<6 ; i++) {
		System.out.println("안내)"+(i+1)+"번째 번호 선택");
		구매번호[i] = sc.nextInt();
		if(구매번호[i]<1 || 구매번호[i]>45) {
			System.err.println("선택할 수 없는 번호입니다.");
			i--;
			continue;
		}
		
		boolean 중복체크 = false;
		for(int j = 0; j<i ; j++) {
			if(구매번호[j]==구매번호[i]) {
			System.err.println("이미 선택된 번호 입니다.");
			중복체크=true;
			}
		}
		if(중복체크) {i--; continue;}
		System.out.println(구매번호[i] + "숫자 선택");
	}
	
	
	for(int i = 0 ; i<6 ; i++) {
		Random rd =new Random();
		추첨번호[i] = rd.nextInt(45)+1;
		for(int j = 0; j<i ; j++) {
			if(추첨번호[j]==추첨번호[i]) {i--;}
		}
	}
	
	
	for(int temp : 구매번호) {
		System.out.printf("%2d\t" , temp);
	}
	System.out.println();
	
	for(int temp : 추첨번호) {
		System.out.printf("%2d\t" , temp);
	}
	System.out.println();
	
	int 당첨개수 = 0 ;
	for(int i = 0 ; i<구매번호.length ; i++) {
		for(int j = 0 ; j<추첨번호.length ; j++) {
			if(구매번호[i]==추첨번호[j]) {당첨개수++;}
		}
	}
	System.out.println("총 당첨 개수 : "+ 당첨개수+"개 입니다.");
	
	
		
	}
}
/*
 * 구매번호 6개수 1~45 ->배열저장
 * 추첨번호 난수 6개발성 -> 배열저장
 * 구매번호와 추첨번호와 동일한 수의 개수
 */
