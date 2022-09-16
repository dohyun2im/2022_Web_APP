package chap1.자유주제;

import java.util.Random;
import java.util.Scanner;

public class game2048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		boolean game = true;       			// 게임 승리시 false;
		
		String[] arr = new String[16];		// 판 생성
		for(int i=0; i<arr.length ; i++) {
			arr[i]="[*]";
			if(i%4==3) {
				arr[i]="[*]\n";
			}
		}

		while(game) {	// 게임시작.	
			
			Function.create(arr); // 난수로 판 속에 [2]칸 생성	
			
			System.out.print("합칠 버튼을 선택하세요 0~15 입력 :"); 
			int slt1 = sc.nextInt();
			
			System.out.print("합칠 버튼을 선택하세요 0~15 입력 :"); 
			int slt2 = sc.nextInt();	
			
			Function.plus(arr, slt1, slt2); //가로 세로 더하기 함수	
			
			Function.victory(arr, game);	//2048이 되면 끝남				
		}		
	}
}
