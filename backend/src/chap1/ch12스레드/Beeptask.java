package chap1.ch12스레드;

import java.awt.Toolkit;

public class Beeptask implements Runnable {
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
}
