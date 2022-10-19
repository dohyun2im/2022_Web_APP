package chap1.ch10예외처리;

public class ex1 {
	public static void main(String[] args) {
		/*String data = null;
		System.out.println(data.toString());
		
		System.out.println(args);
		String data1 = args[0];
		String data2 = args[1];
		System.out.println("data1 : " +data1);
		System.out.println("data2 : " +data2);
		
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
		
		System.out.println(value1);
		System.out.println(value1+value2); 
		*/
		dog dg= new dog();
		changeDog(dg);
		
		cat ct = new cat();
		
	}
	
	public static void changeDog(animal am) {
		if(am instanceof dog) {
			dog dg= (dog) am;
			System.out.println("됨");
		}
		else {
			System.out.println("안됨");
		}
		
	}
}
