package chap1.ch5클래스.ex18접근제한자.getter메소드;

public class Car {
	private int speed;
	private boolean stop;
	
	//간접 접근을 위한 메소드 만들기
	public int getSpeed() {return speed;}
	
	public void setSpeed(int speed) {
		if(speed<0) {this.speed = 0; return;}
		else {this.speed=speed;}	
	}
	
	public boolean isStop() {return stop;}
	
	public void setStop(boolean stop) {this.stop=stop; this.speed=0;}
}
