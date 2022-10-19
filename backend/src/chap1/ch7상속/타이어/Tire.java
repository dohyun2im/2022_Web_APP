package chap1.ch7상속.타이어;

public class Tire {
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+ "타이어의 수명 :" 
		    +(maxRotation-accumulatedRotation)+"회");
			return true;
		}
		else {
			System.out.println("***"+location+"tire 펑크***");
			return false;
		}
	}
	
}
