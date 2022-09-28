package chap1.ch12스레드;

import java.util.Scanner;

public class 예제1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Music ms = new Music(); 
		Movie mv = new Movie();
		Thread thread = new Thread(mv);
		boolean musicState = false;
		boolean movieState = false;
		
		while(true) {
			System.out.println("1.음악재생 2.영화재생"); int ch = sc.nextInt();
			
			if(ch==1 && musicState==false ) {
				ms.start();
				musicState =true;
				}
			
			else if(ch==1 && musicState==true) {
				ms.setStop(false);
				musicState=false;
				ms = new Music();
			}
			
			if(ch==2 && movieState==false) {
				thread.start();
				movieState=true;
			}
			else if (ch==2 && movieState==true) {
				mv.setStop(false);
				movieState=false;
				mv = new Movie();
			}
		}
	}
}
  