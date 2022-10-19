package chap1.ch10예외처리;

public class ex2 {
	public static void main(String[] args) {
		//ClassNotFoundException
		try {
			Class clazz = Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다. "+ e);
		}	
		
		
		
		//NullPointerException
		try {
			String data = null;
			System.out.println(data.toString());
		} catch (NullPointerException e) {
			System.out.println("값이 존재하지 않습니다. "+ e);
		}
		
		
		
		//ArrayIndexOutOfBoundsException
		try {
			System.out.println(args);
			String data1 = args[0];
			String data2 = args[1];
			System.out.println("data1 : " +data1);
			System.out.println("data2 : " +data2);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열에 인덱스값이 존재하지 않습니다. "+ e);
		}
		try {
			int[] arr = new int[3];
			for(int i=0; i<=arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열에 인덱스값이 존재하지 않습니다. "+ e);
		}
		
		
		
		//NumberFormatException
		try {
			String data1 = "100";
			String data2 = "a100";
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			
			System.out.println(value1);
			System.out.println(value1+value2); 
		} catch (NumberFormatException e) {
			System.out.println("정수형 변환 실패. "+ e);
		}
		
		
		
		//ClassCastException
		try {
			dog dg= new dog();
			changeDog(dg);
			
			cat ct = new cat();
			changeDog(ct);
		} catch (ClassCastException e) {
			System.out.println("클래스 변환 실패. "+ e);
		}
	}
	
	public static void changeDog(animal am) {
			dog dg= (dog) am;	
	}
	
}
