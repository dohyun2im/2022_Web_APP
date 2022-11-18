package model.dto;

public class cartDto {
	private int cartno;
	private int pstno;
	private String pname;
	private String pimg;
	private int pprice;
	private float pdiscount;
	private String pcolor;
	private String pssize;
	private int amount;
	
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getPstno() {
		return pstno;
	}
	public void setPstno(int pstno) {
		this.pstno = pstno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public float getPdiscount() {
		return pdiscount;
	}
	public void setPdiscount(float pdiscount) {
		this.pdiscount = pdiscount;
	}
	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}
	public String getPssize() {
		return pssize;
	}
	public void setPssize(String pssize) {
		this.pssize = pssize;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public cartDto(int cartno, int pstno, String pname, String pimg, int pprice, float pdiscount, String pcolor,
			String pssize, int amount) {
		super();
		this.cartno = cartno;
		this.pstno = pstno;
		this.pname = pname;
		this.pimg = pimg;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pcolor = pcolor;
		this.pssize = pssize;
		this.amount = amount;
	}
	public cartDto() {
		super();
	}
	@Override
	public String toString() {
		return "cartDto [cartno=" + cartno + ", pstno=" + pstno + ", pname=" + pname + ", pimg=" + pimg + ", pprice="
				+ pprice + ", pdiscount=" + pdiscount + ", pcolor=" + pcolor + ", pssize=" + pssize + ", amount="
				+ amount + "]";
	}
}
