package chap1.ch7상속.타이어;

public class KumhoTire extends Tire{

	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}

	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+ "금호타이어의 수명 :" 
		    +(maxRotation-accumulatedRotation)+"회");
			return true;
		}
		else {
			System.out.println("***"+location+"금호타이어 펑크***");
			return false;
		}
	}
	
}
