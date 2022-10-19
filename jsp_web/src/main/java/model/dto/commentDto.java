package model.dto;

public class commentDto {
	private String mid;
	private String com;
	private String date;
	private int cnum;
	public commentDto(String mid, String com, String date, int cnum) {
		super();
		this.mid = mid;
		this.com = com;
		this.date = date;
		this.cnum = cnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	@Override
	public String toString() {
		return "commentDto [mid=" + mid + ", com=" + com + ", date=" + date + ", cnum=" + cnum + "]";
	}
}
