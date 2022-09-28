package chap1.ch12스레드;

public class Timer extends Thread{
	
	private boolean stop = true;
	private boolean wait = true;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}


	@Override
	public void run() {
		int i = 1;
		while(stop) {
			if(wait) {
				System.out.println(i+"초");			
				i++;
			}
			try {Thread.sleep(1000);} 
			catch (Exception e) {} 
			System.out.println("스레드 회전중");
		}
	}
}
