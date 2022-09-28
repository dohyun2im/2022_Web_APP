package chap1.ch7상속;

public class ex2_상속2 {
	public static void main(String[] args) {
		Student sd = new Student("홍길동", "123456-1122333", 1);
		
		System.out.println("name : " +sd.name);
		System.out.println("ssn : " +sd.ssn);
		System.out.println("StudentNo : " +sd.studentNo);
	}
}
