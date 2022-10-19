package chap1.ch8인터페이스;

public class 실행 {
	public static void main(String[] args) {
		remotecontrol rc;
		Searchable sc;
		
		//인터페이스 구현객체
		rc = new Television();
		rc.turnOn();
		rc.setVolume(11);
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(12);
		rc.turnOff();
		
		rc = new smartTelevision();
		rc.turnOn();
		rc.setVolume(22);
		rc.turnOff();
		sc = new smartTelevision();
		sc.search("www.naver.com");
	}
}
