package chap1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {  
		int[] arr = new int [10001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int index = 1;
		int result = Integer.parseInt(br.readLine());
		
		for(int i=666; i<2666800; i++) {
			String X = String.valueOf(i);
			for(int j=0; j<X.length()-2 ;j++) {
				if(X.charAt(j)=='6'&&
				   X.charAt(j)==X.charAt(j+1)&& 
				   X.charAt(j+1)==X.charAt(j+2)) {
					if(arr[index-1]!=Integer.parseInt(X)) {
						arr[index]=Integer.parseInt(X);
						if(index==result) {
							System.out.println(arr[index]);
						}
						index++;
					}
					
				}
			}
		}
	}
}


