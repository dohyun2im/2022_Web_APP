package chap1.ch12스레드;

import java.awt.Toolkit;

public class ex1_스레드 {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		System.out.println("싱글 스레드");
		
		for(int i=0; i<5 ; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {} 
		}
		
		for(int i=0; i<5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {} 
		}
		
		
		System.out.println("멀티 스레드");
		//구현객체
		Beeptask bt = new Beeptask();
		Thread thread = new Thread(bt);
		thread.start();
		
		for(int i=0; i<5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {} 
		}
		
		
		
		// 일회용성 익명구현객체
		System.out.println("익명");
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5 ; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} 
					catch (Exception e) {} 
				}
			}
		});
		thread2.start();
		
		for(int i=0; i<5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {} 
		}
		
		
		//extends 일회성
		System.out.println("extend");
		beepthread thread3 = new beepthread(); 
		thread3.start();
		
		for(int i=0; i<5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {} 
		}
		
		//익명 자식 구현객체
		System.out.println("익명자식구현객체");
		Thread thread4 = new Thread() {
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5 ; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} 
					catch (Exception e) {} 
				}
			};
		};
		
		thread4.start();
		
		for(int i=0; i<5 ; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {} 
		}
		
		
		
		
		
		
	}
}
