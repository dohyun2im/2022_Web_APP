package chap1.ch8인터페이스;

public class Television implements remotecontrol{
	private int volume;
	
	public void turnOff() {System.out.println("티비를 끕니다.");}
	
	public void turnOn() {System.out.println("티비를 켭니다.");}
	
	public void setVolume(int volume) {
		if(volume > remotecontrol.MAX_VOLUME) {
			this.volume = remotecontrol.MAX_VOLUME;
		}
		else if(volume < remotecontrol.MIN_VOLUME) {
			this.volume = remotecontrol.MIN_VOLUME;
		}
		else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
}
