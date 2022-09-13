package chap1.ch5클래스.ex5;

public class Car {
	//this.필드명
	//this. ()
	//this.메소드명 
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	Car(){}
	Car(String model){this.model=model;}
	Car(String model , String color){
		this(model,color,5000);
	}
	Car(String model , String color , int maxSpeed){}
	
}
