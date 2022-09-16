package chap1.자유주제;

import java.util.Random;
import java.util.Scanner;

public class Function {
	
	
	static void out(String[] arr) {
		for(String temp : arr) {
			System.out.print(temp);		
		}	
	}
	
	
	
	
	static void create(String[] arr) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			Function.out(arr);
			System.err.println("칸 생성 ? 1)   칸 합치기? 2)"); int slt = sc.nextInt();
			if(slt==1) {
				while(true) {
					Random rd = new Random();
					int index = rd.nextInt(16);
					if(arr[index].equals("[*]") || arr[index].equals("[*]\n") ){
						if(index%4==3) {arr[index]="[2]\n"; break;}
						else {arr[index]="[2]";  break;}	
					}	
				}
			}
			else if(slt==2) {break;}

		}
	}
	
	
	
	
	static void plus(String[] arr,int slt1,int slt2) {
		String A = arr[slt1].replaceAll("[^0-9]", "");
		String B = arr[slt2].replaceAll("[^0-9]", "");
		
		int AA = Integer.parseInt(A);
		int BB = Integer.parseInt(B);
		
		for(int i=0 ; i<13 ; i+=4) { //가로 왼+오 왼쪽으로 더하기
			for(int z=0; z<3 ; z++) {
				if(slt1==(i+z) && slt2==(i+z+1)) {
					if(AA==BB && !arr[slt1].equals("[*]")){
						int C = AA+BB;
						if(slt2%4==3) {
							arr[slt1]= "["+C+"]";
							arr[slt2]= "[*]\n";
						}
						else {
							arr[slt1]= "["+C+"]";
							arr[slt2]= "[*]";
						}
					}
				}
			}
		}
		
		for(int i=1 ; i<14 ; i+=4) { //가로 왼+오 오른쪽으로 더하기
			for(int z=0; z<3 ; z++) {
				if(slt1==(i+z) && slt2==(i+z-1)) {
					if(AA==BB && !arr[slt1].equals("[*]")){
						int C = AA+BB;
						if(slt1%4==3) {
							arr[slt1]= "["+C+"]\n";
							arr[slt2]= "[*]";
						}
						else {
							arr[slt1]= "["+C+"]";
							arr[slt2]= "[*]";
						}
					}
				}
			}
		}
		
		for(int i=0 ; i<13 ; i+=4) { // 세로 위+아래 위로 더하기
			for(int z=0; z<4 ; z++) {
				if(slt1==(i+z) && slt2==(i+z+4)) {
					if(AA==BB && !arr[slt1].equals("[*]")){
						int C = AA+BB;
						if(slt1%4==3 && slt2%4==3) {
							arr[slt1]= "["+C+"]\n";
							arr[slt2]= "[*]\n";
						}
						else {
							arr[slt1]= "["+C+"]";
							arr[slt2]= "[*]";
						}
					}
				}	
			}
		}
		
		for(int i=4 ; i<13 ; i+=4) { // 세로 위+아래 위로 더하기
			for(int z=0; z<4 ; z++) {
				if(slt1==(i+z) && slt2==(i+z-4)) {
					if(AA==BB && !arr[slt1].equals("[*]")){
						int C = AA+BB;
						if(slt1%4==3 && slt2%4==3) {
							arr[slt1]= "["+C+"]\n";
							arr[slt2]= "[*]\n";
						}
						else {
							arr[slt1]= "["+C+"]";
							arr[slt2]= "[*]";
						}
					}
				}	
			}
		}
		
	}
	
	static void victory(String[] arr , boolean game) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("[2048]")) {
				System.err.println("게임 끝 축하합니다.");
				game = false;
			}
		}
	}
	
	
	
}










