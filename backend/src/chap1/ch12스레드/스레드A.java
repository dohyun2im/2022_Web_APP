package chap1.ch12스레드;

public class 스레드A extends Thread{
	
	public 스레드A() {
		setName("스레드A");
	}
	
	@Override
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(getName()+"가 출력한 내용");
		}
	}
}
