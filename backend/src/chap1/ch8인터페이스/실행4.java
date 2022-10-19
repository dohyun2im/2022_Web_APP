package chap1.ch8인터페이스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class 실행4 {
	public static void main(String[] args) {
		Vehicle vc = new Bus();
		vc.run();
		
		System.out.println("관계확인 " + (vc instanceof Bus));
		
		Bus bus = (Bus) vc;
		bus.run();
		bus.checkFare();
		
		//컬렉션프레임워크
		List<String> list;
		list = new ArrayList<>();
			list.add("ㅇㅇ");
		list = new Vector<>();
			list.add("ㅂㅂ");
		list = new LinkedList<>();
			list.add("ㅋㅋ");
		System.out.println(list.toString());
		
		Set<String> set;
	}
}
