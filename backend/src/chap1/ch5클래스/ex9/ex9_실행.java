package chap1.ch5클래스.ex9;

public class ex9_실행 {
	public static void main(String[] args) {
		calculator myCal = new calculator();
		myCal.powerOn();
		
		int result1 = myCal.plus(1, 10);
		System.out.println("result1 : "+result1);
		
		byte x = 4;
		byte y = 10;
		
		double result2 = myCal.divide(x, y);
		System.out.println("result2 : "+result2);
		
		myCal.powerOff();
	}
}
