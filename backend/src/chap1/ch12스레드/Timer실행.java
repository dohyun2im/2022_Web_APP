package chap1.ch12스레드;

import java.util.Scanner;

public class Timer실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Timer timer = new Timer();
		boolean timerstate = false;
		boolean waitstate = true;
		
		while(true) {
			System.out.println("1)타이머 2)리셋");
			int ch = sc.nextInt();
			if(ch==1&&timerstate==false && waitstate==true) {
				timer.start(); timerstate=true;
				}
			else if(ch==1&& timerstate==true && waitstate==true) {
				timer.setWait(false); waitstate=false;
				}
			else if(ch==1&& timerstate==true && waitstate==false) {
				timer.setWait(true); waitstate=true;
				}
			else if(ch==2) {
				timer.setStop(false); timerstate=false; timer = new Timer();
				}
		}
		
			
	}
}
