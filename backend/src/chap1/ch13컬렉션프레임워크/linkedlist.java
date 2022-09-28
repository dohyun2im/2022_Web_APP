package chap1.ch13컬렉션프레임워크;

import java.util.ArrayList;
import java.util.LinkedList;

public class linkedlist {
	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		LinkedList<String> list2 = new LinkedList<>();
		
		long startTime ; //시작시간변수
		long endTime ;
		
		startTime = System.nanoTime();
		for(int i=0; i<100000 ; i++) {
			list1.add(0 , i+"");
		}
		endTime = System.nanoTime();
		
		System.out.println("Arraylist 100000개 삽입하는데 걸리는 시간" +(endTime-startTime)+"ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<100000 ; i++) {
			list2.add(0 , i+"");
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 100000개 삽입하는데 걸리는 시간" +(endTime-startTime)+"ns");
	}
}
