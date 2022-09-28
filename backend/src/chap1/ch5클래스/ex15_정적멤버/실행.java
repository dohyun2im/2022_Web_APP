package chap1.ch5클래스.ex15_정적멤버;

public class 실행 {
	public static void main(String[] args) {
		double result = Calculator.pi2;
		Calculator.plus2(10, 5);
		Calculator.minus2(10, 5);
		
		Calculator c = new Calculator();
		double result1 = c.pi2;
		c.plus(10, 5);
		c.minus(10, 5);
	}
}
