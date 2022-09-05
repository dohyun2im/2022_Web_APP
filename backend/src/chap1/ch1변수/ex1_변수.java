package chap1.ch1변수;

public class ex1_변수 {
	public static void main(String[] args) {
		int value;
		value = 10;
		System.out.println( value );
		int result = value+10 ;
		System.out.println(result);
		int hour = 3;
		int minute = 5;
		System.out.println(hour+"시간"+ minute+"분");
		int totalMinute = (hour*60) + minute;
		System.out.println("총 :" + totalMinute+"분");
		int x =3;
		int y =5;
		System.out.println("x:"+x+"y:"+y);
		int tmp = x;
		x = y;
		y = tmp;
	}
}
