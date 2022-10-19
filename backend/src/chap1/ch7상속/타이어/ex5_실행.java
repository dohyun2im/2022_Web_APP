package chap1.ch7상속.타이어;

public class ex5_실행 {
	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=10;i++) {
			boolean[] result = car.run();
			if(!result[0]) {car.frontLeftTire= new HankookTire(13,"앞왼쪽");}
			if(!result[1]) {car.frontRightTire= new HankookTire(13,"앞오른쪽");}
			if(!result[2]) {car.backLeftTire= new HankookTire(13,"뒤왼쪽");}
			if(!result[3]) {car.backRightTire= new HankookTire(13,"뒤오른쪽");}
		};	
	}
}
