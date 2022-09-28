package chap1.ch7상속;

public class ex3_상속3 {
	public static void main(String[] args) {
		int r = 10;
		Calculator ct = new Calculator();
		System.out.println("원 면적:" + ct.areaCircle(r));
		
		Computer cp = new Computer();
		System.out.println("원 면적:"+ cp.areaCircle(r));
	}
}
