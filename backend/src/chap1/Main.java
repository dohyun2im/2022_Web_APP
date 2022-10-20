package chap1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
		String[] nameArr = new String[n + 1];
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <=n; i++) {
			String name = br.readLine();
			nameMap.put(name, i);
			nameArr[i] = name;
		}
		
		for(int i=1; i<=m; i++) {
			String findStr = br.readLine();
			
			if(findStr.charAt(0)<=64) { 
				int index = Integer.parseInt(findStr);
				sb.append(nameArr[index]);
			}
			
			else {
				sb.append(nameMap.get(findStr));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}


