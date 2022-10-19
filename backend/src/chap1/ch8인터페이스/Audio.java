package chap1.ch8인터페이스;

public class Audio implements remotecontrol{
	private int volume;
	
	@Override
	public void turnOff() {
	System.out.println("Audio를 끕니다.");	
	}
	@Override
	public void turnOn() {
	System.out.println("Audio를 켭니다.");	
	}
	@Override
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
		System.out.println("현재 Audio 볼륨 : " + this.volume);
	}
}
