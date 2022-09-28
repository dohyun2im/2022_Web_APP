package chap1.ch5클래스.ex16싱글톤;

public class Singleton { //객체 1개만 선언
	// private : 현재 클래스에서만 호출가능
	// public : 어디서든 호출 가능
	
	private Singleton() {}
	
	private static Singleton s1 = new Singleton();
	
	public static Singleton getInstance() {
		return s1;
	}
}
