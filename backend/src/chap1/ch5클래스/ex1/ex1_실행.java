package chap1.ch5클래스.ex1;

public class ex1_실행 {
	public static void main(String[] args) {
	//1.클래스명 : 객체 생성시 사용되는 설계도
    //2.변수명 : s1 , 임의 이름
	//3.new 연산자 : 힙영역에 메로리 할당후 주소값을 스택영역 할당
	//4.생성자명 : 객체 생성시 초기값 담당
		
		
	// 필드 : 데이터 저장
	// 생성자 : 객체 생성시 초기화 담당
	// 메소드 : 미리 작성된 코드[동작]
		
	Student s1= new Student();	
	//1     2    3     4 
	System.out.println("s1변수가 student객체를 참조합니다.");
	
	Student s2 = new Student();
	System.out.println("s2변수가 student객체를 참조합니다.");
	
	
	
	
	}
}
