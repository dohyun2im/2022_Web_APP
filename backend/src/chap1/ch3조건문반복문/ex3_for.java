package chap1.ch3조건문반복문;

public class ex3_for {
	public static void main(String[] args) {
		
		
		for(int i=1 ; i<=10 ; i++) {
			System.out.println(i);
		}
		
		
		
		int i = 1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		
		//1~100합
		int sum = 0 ;
		for(int a=1 ; a<=100 ; a++) {
			sum+=a;
		}
		System.out.println(sum);
		
		//1~100합
		int sum2 = 0;
		int b = 1;
		while(b<=100) {
			sum2+=b;
			b++;
		}
		System.out.println(sum2);
		
		
		//1부터 100까지 7의배수 누적합계
		int sum7 = 0;
		for(int x= 0 ; x<=100; x++) {
			if(x%7==0) {
				sum7+=x;
			}
		}
		System.out.println(sum7);
		int sum77 = 0;
		for(int x=0 ; x<=100; x+=7) {
			sum77+=x;
		}
		System.out.println(sum77);
		
		//구구단 2단
		for(int f=1; f<=9; f++) {
				System.out.println("2X"+f+"="+2*f);
		}
		
		int 곱 = 1;
		while(곱<=9) {
			System.out.println("2X"+곱+"="+2*곱);
			곱++;
		}  
		
		//구구단
		
		for(int aa=2 ; aa<=9 ; aa++) {
			for(int bb=1; bb<=9; bb++) {
				System.out.println(aa+"X"+bb+"="+aa*bb);
				System.out.printf("%2dX%2d=%2d\n", aa , bb , (aa*bb));
			}
		}
		
		//무한루프
		while(true) {
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
