package chap1.ch7상속.타이어;

public class HankookTire extends Tire{

	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+ "한국타이어의 수명 :" 
		    +(maxRotation-accumulatedRotation)+"회");
			return true;
		}
		else {
			System.out.println("***"+location+"한국타이어 펑크***");
			return false;
		}
	}
}
