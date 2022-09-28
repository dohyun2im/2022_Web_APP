package chap1.ch5클래스.ex15_정적멤버;

public class Calculator {
	double pi = 3.14159;			// 객체마다 메모리할당
	static double pi2 = 3.14159;	// 메소드 영역에 1번 메모리할당
	
		   int plus(int x, int y) {
		return x+y;
	}
	
	static int plus2(int x, int y) {
		return x+y;
	}
	
	
	 	   int minus(int x, int y) {
		return x-y;
	}
	static int minus2(int x, int y) {
		return x-y;
	}
	
	
}
