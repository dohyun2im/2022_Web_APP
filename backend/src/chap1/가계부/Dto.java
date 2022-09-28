package chap1.가계부;


public class Dto {
	private int m_num ;
	private String m_date ;
	private int price ;
	private String content ;
	
	
	
	public Dto(String m_date, int price) {
		super();
		this.m_date = m_date;
		this.price = price;
	}
	
	public Dto(int m_num, String m_date, int price, String content) {
		this.m_num = m_num;
		this.m_date = m_date;
		this.price = price;
		this.content = content;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}