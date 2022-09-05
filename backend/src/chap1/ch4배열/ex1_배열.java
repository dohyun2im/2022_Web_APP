package chap1.ch4배열;

public class ex1_배열 {
	public static void main(String[] args) {
		/*
		 1.*같은 타입[자료형/클래스]의 데이를 연속된 공간에 나열
		 2.인덱스 : 저장되는 순서번호
		 3.[]
		 	배열 선언
		 		1.타입[] 배열명; 2. 타입 배열명[];ㅣ
		 	
		 */
		int[] scores = {83 , 90 , 87}; //배열생성
		System.out.println("배열[0] : " + scores[0]);
		System.out.println("배열[1] : " + scores[1]);
		System.out.println("배열[2] : " + scores[2]);
		System.out.println("배열 : " + scores);
		
		int sum = 0;
		for(int i = 0 ; i<scores.length; i++) {
			sum+=scores[i];
		}
		System.out.println("총합"+sum);
		System.out.println("평균"+(sum/3.0));
		
		
		
		
		int[] 배열 = new int[3]; // 3개를 저장
		for(int i = 0 ; i<배열.length ; i++) {
			System.out.println(배열[i]);
		}
		
		배열[0] = 100;
		배열[1] = 93;
		배열[2] = 20;
		
		for(int i = 0 ; i<배열.length ; i++) {
			System.out.println(배열[i]);
		}

		for(int temp : 배열) { // 배열내 첫번째 인덱스부터 마지막 인덱스까지 반복변수temp에 하나씩 대입.
			System.err.println(temp);
		}
		
	
	
	
	
	
	
	
	}
}
