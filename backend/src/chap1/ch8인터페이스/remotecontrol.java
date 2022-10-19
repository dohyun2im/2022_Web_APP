package chap1.ch8인터페이스;

public interface remotecontrol {
	
	//상수 선언
	//static final 상수키워드 생략시 자동으로 상수선언
	//초기값 넣어야한다
	
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	//추상 메소드
	//abstract 생략됨.
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
}
