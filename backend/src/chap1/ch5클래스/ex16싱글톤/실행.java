package chap1.ch5클래스.ex16싱글톤;

public class 실행 {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		if(s1==s2) {
			System.out.println("주소값같다");
		}
		else {
			System.out.println("다르다.");
		}
	}
}
