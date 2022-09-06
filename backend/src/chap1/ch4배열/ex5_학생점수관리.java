package chap1.ch4배열;

import java.util.Scanner;

public class ex5_학생점수관리 {
	public static void main(String[] args) {
		
		
		boolean run = true ; 
		
		int studentNum = 0 ;
		
		int[] scores = null ; 
		
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.print(" 선택 : "); int selectNo = sc.nextInt();
			if(selectNo==1){
				System.out.print("학생수 : "); studentNum=sc.nextInt();
				scores = new int[studentNum];
				System.out.println("배열에"+studentNum+"만큼 점수 입력 가능");
			}
			
			else if(selectNo==2){
				for(int i=0; i<scores.length ; i++) {
					System.out.print("score["+i+"]  :"); 
					scores[i] = sc.nextInt();
				}
			}
			
			else if(selectNo==3){
				for(int i = 0 ; i<scores.length; i++) {
					System.out.printf("scores[%d] > %d \n" , i , scores[i]);
				}
			}
			
			else if(selectNo==4){
				int max = 0 ;
				int sum = 0 ; 
				for(int value : scores) {
					if(value>max) {max=value;}
					sum += value;
				}
				System.out.println("최고점수 : " +max );
				double avg = (double)sum/scores.length;
				System.out.println("평균점수 : " +avg );
				
				for(int i = 0 ; i<scores.length ; i++) {
					for(int j = i+1 ; j<scores.length ; j++) {
						if(scores[i]>scores[j]){
							int temp = scores[i];
							scores[i] = scores[j];
							scores[j] = temp;
						}
					}
				}
				for(int value : scores) {System.out.print("내림차순 : "+value);} 
			}
			
			else if(selectNo==5){System.out.println("프로그램 종료중..");  run=false;}
			else {System.out.println("알수없는 번호입니다.");}	
		}
		System.out.println("프로그램 종료");	
	}
}
