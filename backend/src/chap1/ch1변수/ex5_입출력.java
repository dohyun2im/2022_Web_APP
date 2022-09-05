package chap1.ch1변수;

import java.util.Scanner;

public class ex5_입출력 {
	public static void main(String[] args) {
		int 변수 = 123;
		System.out.println(변수 +"원");
		System.out.printf("%d원\n",변수);
		
		int value =123;
		System.out.printf("상품의 가격:%d원\n", value);
		System.out.printf("상품의 가격:%6d원\n" , value);
		System.out.printf("상품의 가격:%-6d원\n" , value);
		System.out.printf("상품의 가격:%06d원\n" , value);
		/*
		 * %d : 정수
		 * %숫자d : 오른쪽부터 숫자만큼 자리 차지[만약에 숫자가 없을경우 공백채움]
		 * %0숫자d : 오른쪽부터 0을 숫자만큼 자리 차지
		 * %-숫자d : 왼쪽부터 숫자만큼 자리 차지
		 * %f : 실수
		 * %10.2f : 10자리의 자리 차지 , 소수점 2자리 표시
		 * */
		
		double area = 3.14159*10*10;
		System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n" , 10 , area);
		
		 String name= "홍길동";
		 String job = "도적";
		 System.out.printf("%6d | %-10s | %10s\n" , 1 , name , job);
		 
		 //입력
		 Scanner 입력객체 = new Scanner(System.in);
		 int 입력정수 = 입력객체.nextInt();
		 System.out.println("입력받은 정수 : " + 입력정수);
		 String 입력문자열 = 입력객체.next();
		 System.out.println("입력받은 문자열 : " + 입력문자열);
		 
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("이름 : ");  String 이름 = scanner.next();
		 System.out.print("나이 : "); int 나이 = scanner.nextInt();
		 System.out.print("키 : "); double 키 = scanner.nextDouble();
		 System.out.println("----------개인정보-------------");
		 System.out.printf("%5s \t %5s %5s \n" , "이름" , "나이" , "키");
		 System.out.printf("%5s \t %5d \t %5.1f", 이름 , 나이 , 키 );
	}
}













