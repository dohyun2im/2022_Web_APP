package chap1.ch2연산자;

import java.util.Scanner;

public class ex2_연산자문제 {
	public static void main(String[] args) {
		//문제1 급여명세서
		Scanner scanner = new Scanner(System.in);
		 int 기본금 = scanner.nextInt();
		 System.out.println("기본금 : "+기본금);
		 int 수당 = scanner.nextInt();
		 System.out.println("수당 : "+수당);
		 System.out.println("실수령액 : "+(int)((기본금*0.9)+수당)+"원");
		 
		//문제2 지폐
		 int 받은돈 = scanner.nextInt();
		 System.out.println("받은돈:"+받은돈);
		 System.out.println("십만원권 :" +받은돈/100000 +'장');
		 System.out.println("만원권 :" +(받은돈/10000)%10 +'장');
		 System.out.println("천원권 :" +(받은돈/1000)%10 +'장');
		 
		//문제3 : 하나의 정수를 입력받아 7의 배수 이면 '맞다' 아니면 '아니다' [ if x ]
		 int 정수 = scanner.nextInt();
		 System.out.println("입력된 정수:"+정수);
		 String 배수 = 정수%7==0? "7의 배수입니다" : "아닙니다";
		 System.out.println("입력된 정수는 7의 배수?:"+배수);
		 
		//문제4 : 하나의 정수를 입력받아 홀수이면 이면 '홀수' 아니면 '짝수' [ if x ]
		 int 정수1 = scanner.nextInt();
		 System.out.println("입력된 정수:"+ 정수1);
		 char 배수1 = 정수1%2==0? '짝' : '홀';
		 System.out.println("입력된 정수는 홀짝?:"+ 배수1);
		 
		//문제5 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 이면 '참' 아니면 '거짓' 
		 int 정수2 = scanner.nextInt();
		 System.out.println("입력된 정수:"+정수2);
		 String 배수2 = 정수%7==0 && 정수2%2==0? "7의배수,짝" : "둘 중 하나X";
		 System.out.println("입력된 정수는 7의배수 && 홀짝?:"+ 배수2);
		
		//문제6 : 두개의 정수를 입력받아 더 큰수 출력
		 int a = scanner.nextInt();
		 System.out.println("입력된 정수:"+a);
		 int b = scanner.nextInt();
		 System.out.println("입력된 정수:"+b);
		 int 정답 = a>b? a:b;
		 System.out.println("더 큰 수:"+정답);
		 
		 //문제7 : 반지름을 입력받아 원 넓이 출력하기 
	 		// 원 넓이 공식 = 반지름 * 반지름 * 원주율[3.14]
		 int 반지름 = scanner.nextInt();
		 System.out.println("입력된 반지름:"+반지름);
		 System.out.println("원의넓이:"+반지름*반지름*3.14);
		  
	 	//문제8 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇 %인지 출력하기 
	 		// 예) 54.5     84.3  입력했으면    64.285714% 출력 
		 double 앞실수 = scanner.nextDouble();
		 System.out.println("입력된 앞정수:"+앞실수);
		 double 뒷실수 = scanner.nextDouble();
		 System.out.println("입력된 뒷정수:"+뒷실수);
		 System.out.printf("앞 값은 뒷값의: %.2f%%" , ((앞실수/뒷실수)*100));
		
	 	//문제9 : 사다리꼴 넓이 구하기 [ 윗변과 밑변 높이를 입력받아 출력하기 ] 
	 		// 사다리꼴 계산식 -> ( 윗변 * 밑변 ) * 높이 / 2 
		 int 윗변 = scanner.nextInt();
		 System.out.println("입력된 윗변:"+윗변);
		 int 밑변 = scanner.nextInt();
		 System.out.println("입력된 밑변:"+밑변);
		 int 높이 = scanner.nextInt();
		 System.out.println("입력된 높이:"+높이);
		 System.out.println("사다리 꼴의 넓이는:"+(float)((윗변*밑변*높이)/2));
		 
	 	//문제10: 키를 정수를 입력받아 표준체중 출력하기
			//표준체중 계산식 = > (키 - 100) * 0.9
		 double 키 = scanner.nextDouble();
		 System.out.println("입력된 키:"+키);
		 System.out.printf("표준 체중은: %.1f" , ((키-100)*0.9));
		//문제11 : 키와 몸무게를 입력받아 BMI 출력하기
			//BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
		 double 몸무게 = scanner.nextDouble();
		 System.out.println("입력된 몸무게:"+몸무게);
		 System.out.printf("bmi는: %.1f" , ( 몸무게 /  ((키/100)*(키/100)) )); 
	 	
		 //문제12 : inch 를 입력받아 cm 로 변환하기 [ 1 inch -> 2.54cm ] 
		 int inch = scanner.nextInt();
		 System.out.println("입력된 inch:"+inch);
		 System.out.printf("cm 변환: %.2f" , ((inch*2.54)));
		 
	 	//문제13 :  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하기
				//소수 둘째 자리 까지 점수 출력하기
				//중간고사 반영비율 => 30 %
				//기말고사 반영비율 => 30 %
				//수행평가 반영비율 => 40 %
		 int 중간고사 = scanner.nextInt();
		 System.out.println("입력된 중간고사:"+중간고사);
		 int 기말고사 = scanner.nextInt();
		 System.out.println("입력된 기말고사:"+기말고사);  
		 int 수행평가 = scanner.nextInt();
		 System.out.println("입력된 수행평가:"+수행평가);
		 System.out.printf("총점: %.2f" , ((중간고사*0.3)+(기말고사*0.3)+(수행평가*0.4))); //
		 
	
		//문제14 :  연산 순서 나열 하고 x와 y값 예측하기
				//int x = 10;
				//int y = x-- + 5 + --x;
				//printf(" x의 값 : %d , y의값 :  %d ", x, y) 

		 
	}
}
