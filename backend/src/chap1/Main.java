package chap1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	static int startstat = 0;
	static int linkstat = 0;
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		StringTokenizer st ;
		for(int i=0; i<N; i++) {	
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {	
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bw.write(String.valueOf(startlink(0)));
		bw.flush();
		bw.close();
	}
	
	//능력치를 비슷하게 맞추자..
	public static int startlink(int team) {
		if(team==N) {
			return Math.abs(startstat-linkstat);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(i!=j && !visit[i][j]) {
					visit[i][j]=true;
					startlink(team+1);
					visit[i][j]=false  ;
				}
			}
		}
		return 0;
	}
	
}