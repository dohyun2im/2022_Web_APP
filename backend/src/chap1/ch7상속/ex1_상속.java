package chap1.ch7상속;

public class ex1_상속 {
	public static void main(String[] args) {
		DmbCellPhone dcp = new DmbCellPhone("자바폰","검정", 10);
		System.out.println("모델 :" + dcp.model);
		System.out.println("색상 :" + dcp.color);
		System.out.println("채널 :" + dcp.channel);
		
		dcp.powerOn();
		dcp.bell();
		dcp.sendVoice("여보세요");
		dcp.receiveVoice("안녕하세요 저는 홍길동인데요");
		dcp.sendVoice("아 네 반갑습니다");
		dcp.hangUp();
		
		dcp.turnOnDmb();
		dcp.changeChannelDmb(1);
		dcp.turnOffDmb();
		
	}
}
