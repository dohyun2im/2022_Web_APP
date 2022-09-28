package chap1.ch13컬렉션프레임워크;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class arraylist {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();
		ArrayList<Double> doubleList = new ArrayList<>();
		ArrayList<Member> memberList = new ArrayList<>();
		list.add("Java"); System.out.println("리스트 현황 :" +list.toString());
		list.add("JDBC"); System.out.println("리스트 현황 :" +list.toString());
		list.add("server.jsp"); System.out.println("리스트 현황 :" +list.toString());
		list.add(2,"database"); System.out.println("리스트 현황 :" +list.toString());
		list.add("ibatis"); System.out.println("리스트 현황 :" +list.toString());
		
		System.out.println("리스트 길이 :" +list.size());
		
		System.out.println("리스트 가져오기 :" +list.get(0));
		
		System.out.println("리스트 삭제 :" +list.remove(0));  System.out.println("리스트 현황 :" +list.toString());
		
		for(int i=0; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		for(String s : list ) {
			System.out.println(s);
		}
		
		System.out.println("리스트 현황 :" +list.isEmpty()); // 객체가 비어 있으면 트루
		System.out.println("리스트 현황 :" +list.contains("JDBC")); //해당 객체가 존재하면 틑루
		System.out.println("리스트 현황 :" +list.indexOf("JDBC")); // 몇번째 인덱스에 존재하는지
		System.out.println("리스트 현황 :" +list.iterator());//순회함수 
		
		//list.clear();
		//System.out.println("리스트 현황 :" +list.toString());
		
	}
}
