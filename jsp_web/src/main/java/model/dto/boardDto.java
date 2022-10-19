package model.dto;

public class boardDto {
	private int mnum;
	private int bnum;
	private int cnum;
	private String btitle;
	private String bcon;
	private String bfile;
	private String bdate;
	private int bview;
	private String mid;
	
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcon() {
		return bcon;
	}
	public void setBcon(String bcon) {
		this.bcon = bcon;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public boardDto(int mnum, int bnum, String btitle, String bcon) {
		super();
		this.mnum = mnum;
		this.bnum = bnum;
		this.btitle = btitle;
		this.bcon = bcon;
	}
	public boardDto(int mnum, int bnum, int cnum, String btitle, String bcon, String bfile, String bdate, int bview,
			String mid) {
		super();
		this.mnum = mnum;
		this.bnum = bnum;
		this.cnum = cnum;
		this.btitle = btitle;
		this.bcon = bcon;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mid = mid;
	}
	public boardDto(String btitle, String bcon) {
		super();
		this.btitle = btitle;
		this.bcon = bcon;
	}
	public boardDto(int mnum, int bnum, String btitle, String bcon, String bdate, int bview) {
		super();
		this.mnum = mnum;
		this.bnum = bnum;
		this.btitle = btitle;
		this.bcon = bcon;
		this.bdate = bdate;
		this.bview = bview;
	}
	@Override
	public String toString() {
		return "boardDto [mnum=" + mnum + ", bnum=" + bnum + ", cnum=" + cnum + ", btitle=" + btitle + ", bcon=" + bcon
				+ ", bfile=" + bfile + ", bdate=" + bdate + ", bview=" + bview + ", mid=" + mid + "]";
	}
	
}
