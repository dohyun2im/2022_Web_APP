package chap1.ch11api클래스;

import java.io.IOException;

public class ex1_string {
	public static void main(String[] args) throws IOException {
		byte b = 72; 
		char c = (char) b; System.out.println(c);
		byte[] bytes= {72,101,108,108,111,32,74,97,118,97};
		char[] chars = new char[10];
		String str = new String(bytes); System.out.println(str);
		String str1 = new String(bytes, 6 , 4 ); System.out.println(str1);
		
		byte[] bytes2 = new byte[100];
		System.out.println("입력"); int read = System.in.read(bytes2);
	
		String str3 = new String(bytes2 , 0 , read-2);
		System.out.println(str3);
	}
}
