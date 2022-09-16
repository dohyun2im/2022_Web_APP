package chap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		int count = 0 ;
		for(int i=0; i<T.length(); i++) {
			int N = (T.charAt(i));
			if(65<=N && N<=67) {
				count+=3;
			}
			else if(68<=N && N<=70) {
				count+=4;
			}
			else if(71<=N && N<=73) {
				count+=5;
			}
			else if(74<=N && N<=76) {
				count+=6;
			}
			else if(77<=N && N<=79) {
				count+=7;
			}
			else if(80<=N && N<=83) {
				count+=8;
			}
			else if(84<=N && N<=86) {
				count+=9;
			}
			else if(87<=N && N<=90) {
				count+=10;
			}
		}		
		System.out.println(count);
	}
}


