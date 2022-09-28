package chap1.ch5클래스.ex14_인스턴스멤버;

public class 실행 {
	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		yourCar.run();
	}
}
