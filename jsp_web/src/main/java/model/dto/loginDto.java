package model.dto;

public class loginDto {
	private String mid;	
	private String mpw;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public loginDto() {
		// TODO Auto-generated constructor stub
	}
	public loginDto(String mid, String mpw) {
		super();
		this.mid = mid;
		this.mpw = mpw;
	}
	@Override
	public String toString() {
		return "loginDto [mid=" + mid + ", mpw=" + mpw + "]";
	}	
}
