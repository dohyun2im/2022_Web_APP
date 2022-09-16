package chap1.ch5클래스.ex8;

public class Member {
	// 필드
	String id;
	String password;
	String name;
	
	// 생성자 클래스명과 동일 매개변수 개수에따라 오버로딩
	Member(){}
	
	Member(String id){
		this.id=id;
	};
	
	Member(String id , String password){
		this.id=id;
		this.password=password;
	};

	Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	};
	
	
	
	
}
