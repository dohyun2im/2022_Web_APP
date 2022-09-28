package chap1.키오스크.관리자;

public class ProductDto {
	private String pname; 
	private int pprice;
	private String pcomment;
	private int pamount;
	private int mno;
	
	public ProductDto() {};
	
	public ProductDto(String pname, int pprice, String pcomment, int pamount, int mno) {
		this.pname = pname;
		this.pprice = pprice;
		this.pcomment = pcomment;
		this.pamount = pamount;
		this.mno = mno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPcomment() {
		return pcomment;
	}

	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}

	public int getPamount() {
		return pamount;
	}

	public void setPamount(int pamount) {
		this.pamount = pamount;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	
	
}
