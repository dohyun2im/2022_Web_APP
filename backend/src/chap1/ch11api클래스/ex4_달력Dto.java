package chap1.ch11api클래스;

public class ex4_달력Dto {
	private int Num;
	private String mm;
	private String memo;
	public ex4_달력Dto(int num, String mm, String memo) {
		super();
		Num = num;
		this.mm = mm;
		this.memo = memo;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
