package chap1.ch3조건문반복문;

import java.util.Scanner;

public class ex2_if연습문제 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	/*	//2개중 더 큰수
		int 정수1 = scanner.nextInt();
		System.out.println(정수1);
		int 정수2 = scanner.nextInt();
		System.out.println(정수2);
		if(정수1>정수2) {System.out.println(정수1+"이 더 큽니다.");}
		else if(정수1<정수2) {System.out.println(정수2+"이 더 큽니다.");}
		else{System.out.println("둘이 같습니다.");}
		
		int 정수3 = scanner.nextInt();
		System.out.println(정수3);
		int 정수4 = scanner.nextInt();
		System.out.println(정수4);
		int 정수5 = scanner.nextInt();
		System.out.println(정수5);
		int max = 정수3;
		if(max<정수4){max=정수4;}
		if(max<정수5){max=정수5;}
		System.out.println(max+"가 더 큽니다.");
		
		int 정수6 = scanner.nextInt();
		System.out.println(정수6);
		int 정수7 = scanner.nextInt();
		System.out.println(정수7);
		int 정수8 = scanner.nextInt();
		System.out.println(정수8);
		int 정수9 = scanner.nextInt();
		System.out.println(정수9);
		if(정수6>정수7&&정수6>정수8&&정수6>정수9){System.out.println(정수6+"이 더 큽니다.");}
		else if(정수7>정수6&&정수7>정수8&&정수7>정수9){System.out.println(정수7+"이 더 큽니다.");}
		else if(정수8>정수6&&정수8>정수7&&정수8>정수9){System.out.println(정수8+"이 더 큽니다.");}
		else if(정수9>정수6&&정수9>정수7&&정수9>정수8){System.out.println(정수9+"이 더 큽니다.");}
		
		*/
		int a = scanner.nextInt();
		System.out.println(a);
		int b = scanner.nextInt();
		System.out.println(b);
		int c = scanner.nextInt();
		System.out.println(c);
		
		if(a>b) {int temp= a; a=b; b=temp;}
		if(a>c) {int temp= a; a=c; c=temp;}
		if(b>c) {int temp= b; b=c; c=temp;}
		System.out.printf("%d %d %d \n", a , b , c );
		
		if(a<b) {int temp= a; a=b; b=temp;}
		if(a<c) {int temp= a; a=c; c=temp;}
		if(b<c) {int temp= b; b=c; c=temp;}
		System.out.printf("%d %d %d \n", a , b , c );
		
				
		int 점수 = scanner.nextInt();
		System.out.println(점수);
		if(점수>=90) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		if(점수>=90) {
			System.out.println("A");
		}else if(점수>=80){
			System.out.println("B");
		}else if(점수>=70) {
			System.out.println("C");
		}else {
			System.out.println("재시험");
		}
		
		
		int 국어 = scanner.nextInt();
		System.out.println(국어);
		int 영어 = scanner.nextInt();
		System.out.println(영어);
		int 수학 = scanner.nextInt();
		System.out.println(수학);
		double 평균 = (국어+영어+수학)/3;
		if(평균>=90) {
			if(국어>=100) {System.out.println("국어우수");}
			if(영어>=100) {System.out.println("영어우수");}
			if(수학>=100) {System.out.println("수학우수");}
		}else if(평균>=80) {
			if(국어>=90) {System.out.println("국어우수");}
			if(영어>=90) {System.out.println("영어우수");}
			if(수학>=90) {System.out.println("수학우수");}
		}else {System.out.println("재시험");}
		
		
		String 아이디 = scanner.next();
		System.out.println(아이디);
		String 비밀번호 = scanner.next();
		System.out.println(비밀번호);
		if(아이디.equals("admin")) {
			if(비밀번호.equals("1234")) {
				System.out.println("로그인 완료");
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
				}
		}else {
			System.out.println("아이디가 틀렸습니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
