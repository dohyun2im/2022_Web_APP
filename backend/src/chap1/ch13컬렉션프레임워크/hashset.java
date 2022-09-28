package chap1.ch13컬렉션프레임워크;

import java.util.HashSet;
import java.util.Iterator;
/*
 * get 못씀
 * remove로 객체 제거
 * 인덱스가 없다
 */
public class hashset {
	public static void main(String[] args) {
		HashSet<String> s = new HashSet<>();
		s.add("Java"); 		  System.out.println("s 현황 :" +s.toString());
		s.add("jdbc");		  System.out.println("s 현황 :" +s.toString());
		s.add("servlet/jsp"); System.out.println("s 현황 :" +s.toString());
		s.add("Java");		  System.out.println("s 현황 :" +s.toString());
		s.add("ibatis");      System.out.println("s 현황 :" +s.toString());
		System.out.println("set내 객체 수 " + s.size());
		
		System.out.printf("java 문자열의 해시코드 변환 : %x \n","java".hashCode());
		
		Iterator<String> i = s.iterator(); //Iterator 순서없는 자료들을 하나씩 순회하는 인터페이스
		while(i.hasNext()) {
			String element = i.next();
			System.out.println("\t"+element);
		}
		
		for(int z=0 ; z<s.size(); z++) {
			System.out.println(s.toString());
		}
		
		for(String a : s) {
			System.out.println("\t"+a);
		}
		
		
	}
}
