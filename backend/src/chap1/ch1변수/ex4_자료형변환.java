package chap1.ch1변수;

public class ex4_자료형변환 {
	public static void main(String[] args) {
		/*
		 자동타입변환: 작은 자료형 --> 큰 자료형
		 			byte->short->int->long->float->double
		 강제타입변환: 큰 자료형 --> 작은 자료형
		 			데이터 손실발생
		integer.parseInt(문자열) - > 숫자 			
		 */
		byte 바이트변수 = 10;
		int 인트변수 = 바이트변수;
		//byte 바이트변수2 = 인트변수; // false;
		byte 바이트변수3 = (byte)인트변수;  System.out.println(바이트변수3);
		
		
		
	}
}
