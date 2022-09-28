package chap1.ch11api클래스;

import java.io.UnsupportedEncodingException;

public class ex2_string메소드 {
	public static void main(String[] args) throws UnsupportedEncodingException{
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);
		
		switch(sex) {
		case '1' :
		case '3' :
			System.out.println("남자"); break;
		case '2' :
		case '4' :
			System.out.println("여자"); break;
		}
		
		System.out.println(sex);
		
		String strVar1 = new String("신문철");
		String strVar2 = "신문철";
		
		if(strVar1==strVar2) {
			System.out.println("같은 스트링 객체 참조");
		}
		else {
			System.err.println("다른 스트링 객체 참조");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열");
		}
		
		String str= "안녕하세요";
		byte[] bytes1 = str.getBytes(); System.out.println("문자열-> 바이트열 길이 : " +bytes1.length);
		String str1 = new String(bytes1); System.out.println("바이트열-> 문자열 길이 : " + str1);
		
		String str2= "EUC-KR";
		byte[] bytes2 = str.getBytes("EUC-KR"); System.out.println("문자열-> 바이트열EUC-KR 길이 : " +bytes2.length);
		String str3= "UTF-8";
		byte[] bytes3 = str.getBytes("UTF-8");  System.out.println("문자열-> 바이트열UTF-8 길이 : " +bytes3.length);
		
		String subject = "자바 프로그래밍";
		
		System.out.println(subject.indexOf("프로그래밍"));
		
		int location = subject.indexOf("프로그래밍");
		
		if(location>-1) {
			System.out.println("찾았다.");
		}
		else {
			System.out.println("못찾았다...");
		}
		
		String ssn2 = "730624-1230123";
		int length = ssn.length();
		if(length==14) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}
		else {
			System.err.println("주민번호 자리수가 틀립니다.");
		}
		
		String oldStr = "자바는 객체지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "java");
		System.out.println(oldStr);
		System.out.println(newStr);
		
		String str4 = "Java programming";
		System.out.println("소문자 변환 : " +str4.toLowerCase());
		System.out.println("대문자 변환 : " +str4.toUpperCase());
		
		String tel1 = "            0 2";
		String tel2 = " 12 3           ";
		String tel3 = "              1   2   3           ";
		System.out.println(tel1.trim());
		System.out.println(tel2.trim());
		System.out.println(tel3.trim());
		
		
		String ssn11 = "880815-1234567";
		String first = ssn11.substring(0,6);
		String second = ssn11.substring(7);
		System.out.println(first);
		System.out.println(second);
		String[] result = ssn11.split("-");
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
