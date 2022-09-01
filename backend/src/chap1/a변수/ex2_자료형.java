package chap1.a변수;

public class ex2_자료형 {
	public static void main(String[] args) {
		//int 정수 기본 자료형 10진수 +-20억
		int var1 = 0b1011; System.out.println(var1);
		int var2 = 0206; System.out.println(var2);
		int var3 = 365;  System.out.println(var3);
		int var4 = 0xB3; System.out.println(var4);

		//long 입력숫자뒤에 L; int보다 큰 수 
		long 롱변수1 = 10000000000L; System.out.println(롱변수1);
		//byte -128~127
		byte 바이트변수1 = -128; System.out.println(바이트변수1); 
		byte 바이트변수2 = 127; System.out.println(바이트변수2);
		
		//char
		char 문자변수1 = 65; System.out.println(문자변수1);
		char 문자변수2 = 'A'; System.out.println(문자변수2);
		int 문자변수3= 'A'; System.out.println(문자변수3); 
		char 문자변수4= '가'; System.out.println(문자변수4);
		int 문자변수5= '가'; System.out.println(문자변수5); 
		
		//short 10진수 +-3만
		short 쇼트변수1 = 30000; System.out.println(쇼트변수1);
		//short 쇼트변수2 = 40000; System.out.println(쇼트변수2);
		
		
	}
}
