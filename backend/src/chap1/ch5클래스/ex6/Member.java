package chap1.ch5클래스.ex6;

public class Member {
	String id;
	String password;
	String name;
	int point;
	
	//빈생성자
	public Member() {} 
	
	//회원가입시 사용되는 생성자
	Member(String id , String password , String name , int point){
		this.id=id; //내부필드와 매개변수 이름 식별용;
		this.password=password;
		this.name=name;
		this.point=point;
	}
	
	//회원수정시 사용되는 생성자
	Member(String password){
		this.password=password;
	}
	
	//로그인시 사용되는 생성자
	Member(String id , String password){
		this.id=id;
		this.password=password;
	}
}
