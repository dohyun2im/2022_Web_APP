package chap1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
 
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
 
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			 System.out.println(tangent(x1, y1, r1, x2, y2, r2));
		}
	}
	// 접점 개수 구하는 함수
	public static int tangent(int x1, int y1, int r1, int x2, int y2, int r2) {
		int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	// 중점간 거리 distance의 제곱 
 
		// 무한히 많은 경우  
		if(x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		}	
		// 두 원이 접점없이 멀리 있을때
		else if(distance > Math.pow(r1 + r2, 2)) {
			return 0;
		}
		// 한원안에 다른원이 안에 있으나 겹치는 부분이 없을떄
		else if(distance < Math.pow(r2 - r1, 2)) {
			return 0;
		}
		// 한원안에 다른원이 안에 있고 내접할 때 
		else if(distance == Math.pow(r2 - r1, 2)) {
			return 1;
		}	
		// 외부에서 외접할 때 
		else if(distance == Math.pow(r1 + r2, 2)) {
			return 1;
		}
		else {
			return 2;
		}	
	}
}