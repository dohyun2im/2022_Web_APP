package chap1.ch5클래스.ex9;

public class calculator {
	//필드
	
	//생성자
	
	//메소드
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus(int x , int y ) {
		int result = x+y;
		return result;
	}
	
	double divide(int x , int y ) {
		double result = (double)x / (double)y;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

}
