package model.dto;

public class stockDto {
	private int psno ; 
	private String pssize;
	private int pstno ;
	private String pcolor;
	private int pstock;
	
	public int getPsno() {
		return psno;
	}
	public void setPsno(int psno) {
		this.psno = psno;
	}
	public String getPssize() {
		return pssize;
	}
	public void setPssize(String pssize) {
		this.pssize = pssize;
	}
	public int getPstno() {
		return pstno;
	}
	public void setPstno(int pstno) {
		this.pstno = pstno;
	}
	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	
	@Override
	public String toString() {
		return "stockDto [psno=" + psno + ", pssize=" + pssize + ", pstno=" + pstno + ", pcolor=" + pcolor + ", pstock="
				+ pstock + "]";
	}
	public stockDto() {
		super();
	}
	public stockDto(int psno, String pssize, int pstno, String pcolor, int pstock) {
		super();
		this.psno = psno;
		this.pssize = pssize;
		this.pstno = pstno;
		this.pcolor = pcolor;
		this.pstock = pstock;
	}
}
