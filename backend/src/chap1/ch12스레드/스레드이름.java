package chap1.ch12스레드;

public class 스레드이름 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("main함수에 있는 스레드 이름은? : " + mainThread.getName());
		스레드A a = new 스레드A();
		a.start();
		
		스레드B b = new 스레드B();
		b.start();
	}
}
