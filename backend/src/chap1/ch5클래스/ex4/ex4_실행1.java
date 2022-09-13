package chap1.ch5클래스.ex4;

public class ex4_실행1 {
	public static void main(String[] args) {
		Korean k1 = new Korean("박자바","01085832621");
		
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		System.out.println(k1.nation);
		
		
		Korean k2 = new Korean();
		k2.name="박자바";
		k2.ssn="010-8583-2621";
		
		System.out.println(k2.name);
		System.out.println(k2.ssn);
		System.out.println(k2.nation);
		
	}
}
