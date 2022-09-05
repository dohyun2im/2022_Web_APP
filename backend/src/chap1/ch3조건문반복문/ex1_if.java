package chap1.ch3조건문반복문;

public class ex1_if {
	public static void main(String[] args) {
		/*
		 * if (조건) 참
		 * 
		 * if(조건){참}
		 * 
		 * if(조건){참}
		 * else{거짓}
		 * 
		 * if(조건){참}
		 * else if(조건1){참1}
		 * else if(조건2){참2}
		 * else if(조건3){참3}
		 * else{거짓}
		 * 
		 * if(조건){
		 * 	if(조건){
		 * 	 참
		 * 	}else{
		 * 	 거짓
		 * 	}
		 * }
		 * */
		if(3>1)System.out.println("예1)3이 1보다 크다");
		
		if(3>5)System.out.println("예2)3이 5보다 크다"); //false라서 실행 x
		
		int score = 93;
		
		if(score>=90) {//실행문 2개 이상
			System.out.println("점수가 90보다 큽니다");
			System.out.println("등급은 A입니다.");
		}
		
		if(score<90){
			System.out.println("점수가 90보다 작습니다");
			System.out.println("등급은 B입니다.");
		}
		
		//p137
		int score1 = 85;
		if(score1>=90){
			System.out.println("점수가 90보다 큽니다");
			System.out.println("등급은 A입니다.");
		} else {
			System.out.println("점수가 90보다 작습니다");
			System.out.println("등급은 B입니다.");
		}
		
		int score2 = 75;
		if(score2>=90) {
			System.out.println("점수가 100~90입니다");
			System.out.println("등급은 A입니다.");
		}else if(score2>=80) {
			System.out.println("점수가 89~80입니다");
			System.out.println("등급은 B입니다.");
		}else if(score2>=70) {
			System.out.println("점수가 79~70입니다");
			System.out.println("등급은 C입니다.");
		}else{
			System.out.println("점수가 70미만입니다");
			System.out.println("등급은 D입니다.");
		}
		
		if(score2>=90) {
			System.out.println("점수가 100~90입니다");
			System.out.println("등급은 A입니다.");
		}if(score2>=80) {
			System.out.println("점수가 89~80입니다");
			System.out.println("등급은 B입니다.");
		}if(score2>=70) {
			System.out.println("점수가 79~70입니다");
			System.out.println("등급은 C입니다.");
		}if(score2<70){
			System.out.println("점수가 70미만입니다");
			System.out.println("등급은 D입니다.");
		}
		
		
		
		int score4=95; char 성별='M';
		if(score4==100) {
			if(성별 =='M') {
				System.out.println("100점이면서 남자이다.");
			}else {
				System.out.println("100점이면서 여자이다.");
			}
		}
		else {
			if(성별=='F') {
				System.out.println("100점아니면서 여자이다.");
			}else {
				System.out.println("100점아니면서 여자이다.");
			}		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
