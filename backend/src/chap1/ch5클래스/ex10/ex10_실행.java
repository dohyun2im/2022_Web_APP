package chap1.ch5클래스.ex10;

public class ex10_실행 {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(10);
		
		boolean gasState = myCar.isLeftGas();
		
		if(gasState) {
		System.out.println("출발합니다");
		myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		}
		else {
			System.out.println("가스를 주입하세요.");
		}
		
	}
}
