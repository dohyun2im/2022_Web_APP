package chap1.ch5클래스.ex6;

import java.util.Scanner;

public class ex6_실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member[] MemberObject = new Member[100];
		while(true) {
			System.out.println("1.회원가입 2.로그인");
			int ch = sc.nextInt();
			if(ch==1) {
				System.out.print("아이디 : ");    String id =sc.next();
				System.out.print("비밀번호 : ");	String password =sc.next();
				System.out.print("이름 : ");		String name =sc.next();
				Member signupInfo = new Member(id , password , name , 1000);
				int index=0;
				for(Member temp : MemberObject) {
					index++;
					if(temp == null) {
						MemberObject[index] = signupInfo;
						break;
					}
				}
			}
			else if(ch==2) {
				System.out.print("아이디 : ");    String id =sc.next();
				System.out.print("비밀번호 : ");	String password =sc.next();
				Member loginInfo = new Member(id , password);
				for(Member temp : MemberObject) {
					if(temp!=null && 
					   temp.id.equals(loginInfo.id) && 
					   temp.password.equals(loginInfo.password) ) {
						System.out.println("로그인 성공");
						break;
					}
				}
			}
		}
	}
}
