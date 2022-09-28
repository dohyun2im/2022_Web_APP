package chap1.ch13컬렉션프레임워크;

import java.util.HashMap;

public class hashmap {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		/*
		 * 키는 중복이 불가능하다.
		 * 값 중복 가능
		 */
		map.put("신용권", 85); System.out.println(map.toString());
		map.put("홍길동", 90); System.out.println(map.toString());
		map.put("동장군", 80); System.out.println(map.toString());
		map.put("홍길동", 95); System.out.println(map.toString());
		
		System.out.println("엔트리(키:값) 수"+map.size());
		
		System.out.println("키 호출시 값 나옴:"+map.get("신용권"));
		
		for(String key : map.keySet()) {
			System.out.println("키 모두 호출:"+key);
			System.out.println("값 모두 호출:"+map.get(key));
		}
	}
}
