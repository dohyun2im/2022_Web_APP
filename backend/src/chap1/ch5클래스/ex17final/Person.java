package chap1.ch5클래스.ex17final;

public class Person {
	final String nation = "Korea";
	final String ssn;
	String name;
	
	static final double EARTH_RADIUS = 6400;
	
		
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
}
