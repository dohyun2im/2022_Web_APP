package chap1.ch3조건문반복문;

import java.util.Random;
import java.util.Scanner;

/*
 	1. 플레이어에게 가위[0] 바위[1] 보[2]
 	2. 컴퓨터에게 난수생성 random [0~2]
 		Random 변수명 = new random()
 			*변수명.nextint(수) : 0~수-1까지 발생
 	3.승리판단
 	4.게임종료시 최종승리자 출력 , 게임판수
 	[메뉴]
 		가위(0) 바위(1) 보(2) 종료(3)
 	
 */
public class ex6_가위바위보 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int 플레이어; 
		int 컴퓨터;
		int 플레이어승리=0; 
		int 컴퓨터승리=0;
		
		while(true) {
			System.out.println("가위(0) 바위(1) 보(2) 종료(3)"); 
			플레이어 = sc.nextInt();
			
			Random random = new Random();
			컴퓨터 = random.nextInt(3);
			
			if(플레이어>=0 && 플레이어<=2) {
				if((플레이어==0&&컴퓨터==2)|| (플레이어==1&&컴퓨터==0) || (플레이어==2&&컴퓨터==1) ){
					System.out.println("결과) 플레이어 승리");
					플레이어승리++;
				}
				else if((플레이어==0&&컴퓨터==0)|| (플레이어==1&&컴퓨터==1) || (플레이어==2&&컴퓨터==2)) {
					System.out.println("결과) 무승부");
				}
				else {
					System.out.println("결과) 컴퓨터 승리");
					컴퓨터승리++;
				}
			}
			
			else if(플레이어==3) {
				if(플레이어승리>컴퓨터승리) {
					System.out.println((플레이어승리+컴퓨터승리)+"판 진행 결과) 플레이어 "+(플레이어승리-컴퓨터승리)+"판 더 승리");
					}
				else if(컴퓨터승리>플레이어승리) {
					System.out.println((플레이어승리+컴퓨터승리)+"판 진행 결과) 컴퓨터 "+(컴퓨터승리-플레이어승리)+"판 더 승리");
					}
				else {
					System.out.println("결과) 무승부 ");
					}
				break;
			}
			
			else {System.err.println("숫자를 다시 입력하세요 !");}
		}
	}
}
