package chap1.ch8인터페이스;

public class 실행3 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.Run();
		//구현객체교체
		myCar.frontLeftTire = new GeumhoTire();
		myCar.frontRightTire = new GeumhoTire();
		
		myCar.Run();
	}
}
