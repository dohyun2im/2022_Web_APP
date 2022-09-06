package chap1.ch4배열;

public class ex4_배열2 {
	public static void main(String[] args) {
		//1차원배열 []
		String[] 배열1 = new String[10];
		배열1[0] = "유재석"; 배열1[1] = "강호동"; 배열1[2] = "신동엽";
		//수정
		배열1[0] = "하하";
		//삭제
		배열1[0] = null;
		//모든항목호출
		for(String value:배열1) {
			System.out.println(value);
		}
		
		//2차원배열 [] []
		String[][] 배열2 = new String[10][3];
		배열2[0][0] = "유재석"; 배열2[0][1] = "010-4444-4444";
		배열2[1][0] = "강호동"; 배열2[1][1] = "010-1444-4444";
		배열2[2][0] = "신동엽"; 배열2[2][1] = "010-2444-4444";
		//수정
		배열2[0][0] = "하하";  배열2[0][1] = "010-1234-4444";
		//삭제
		배열2[1][0] = null; 배열2[1][1] = null;
		
		for(int i = 0 ; i<배열2.length ; i++) {
			for(int j = 0 ; j<배열2[i].length ; j++) {
				System.out.print(배열2[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		//3차원배열 [] [] [] 
		String[][][] 배열3 = new String[10][2][3];
		
		
	}
}
