package model.dto;

public class categoryDto {
	private int pcno ;
	private String pcname ;
	public int getPcno() {
		return pcno;
	}
	public void setPcno(int pcno) {
		this.pcno = pcno;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public categoryDto(int pcno, String pcname) {
		super();
		this.pcno = pcno;
		this.pcname = pcname;
	}
	public categoryDto() {
		super();
	}
	@Override
	public String toString() {
		return "categoryDto [pcno=" + pcno + ", pcname=" + pcname + "]";
	}
}
