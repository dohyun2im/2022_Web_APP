package model.dto;

public class memberDto {
	private int mnum;
	private String mid;	
	private String mpw;	
	private String mname;
	private String mpn;
	private String memail;
	private String maddr;
	private String mdate;
	private int mpoint;
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpn() {
		return mpn;
	}
	public void setMpn(String mpn) {
		this.mpn = mpn;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	public memberDto() {}
	public memberDto(int mnum, String mid, String mpw, String mname, String mpn, String memail, String maddr,
			String mdate, int mpoint) {
		super();
		this.mnum = mnum;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mpn = mpn;
		this.memail = memail;
		this.maddr = maddr;
		this.mdate = mdate;
		this.mpoint = mpoint;
	}
	@Override
	public String toString() {
		return "memberDto [mnum=" + mnum + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mpn=" + mpn
				+ ", memail=" + memail + ", maddr=" + maddr + ", mdate=" + mdate + ", mpoint=" + mpoint + "]";
	}
}
