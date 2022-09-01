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
		
		//실수 타입
		// double 소수점 17자리 실수 기본자료형
 		// float 소수점 7자리
		double 실수1 = 3.14; System.out.println(실수1);
		float 실수2 = 3.14f; System.out.println(실수2);
		double 실수3 = 0.144554545455111111111114; System.out.println(실수3);
		float 실수4 = 0.14111223456677f; System.out.println(실수4);
		
		//논리타입
		// boolean true false
		boolean 논리변수1 = true; System.out.println(논리변수1);
		
		/*
		  bit : 0 / 1
		  byte : bit8자리 -> 1byte [1byte -> 01010101 -> 8bit]
		  kbyte : 1024byte -> kbyte
		  mbyte : 1924kbte -> 1mb
		  GB : 1024mb -> 1GB
		  	1.정수타입
		  	byte     1바이트 +-100
		  	char     2바이트 유니코드 한영
		  	short    2바이트 +-30000
		  	int      4바이트 +-20억
		  	long     8바이트 +-20억이상
		  	2.실수타입
		  	float   4바이트 소수점8자리
		  	double  8바이트 소주점17자리
		  	3.논리
		  	boolean 1바이트 true false
		  
		 */
		
		
		
		
		
		
		
	}
}
