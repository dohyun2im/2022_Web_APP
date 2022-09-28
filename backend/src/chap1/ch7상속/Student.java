package chap1.ch7상속;

public class Student extends Peaple{
	int studentNo;
	
	public Student(String name,String ssn ,int studentNo) {
		super(name,ssn);
		this.studentNo=studentNo;
	}
}
