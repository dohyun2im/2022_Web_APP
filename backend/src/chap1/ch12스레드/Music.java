package chap1.ch12스레드;

public class Music extends Thread{
	//필드
	boolean stop = true;
	
	//생성자
	public void setStop(boolean stop) {
		this.stop=stop;
	}
	
	public void run() {
		while(stop) {
			System.out.println("음악 재생중");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
		
	}
}
