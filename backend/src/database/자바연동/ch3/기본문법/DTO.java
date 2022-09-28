package database.자바연동.ch3.기본문법;

public class DTO {
	String mem_id;
	String mem_name;
	int mem_number;
	String addr;
	String phone1;
	String phone2;
	short height;
	String debut_date;
	int sum;
	
	DTO() {}
	
	DTO(String mem_id,int sum) {
		this.mem_id = mem_id;
		this.sum = sum;
	}

	
	DTO(String mem_id,String mem_name , String debut_date) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.debut_date = debut_date;
	}
	
	DTO(String mem_id,String mem_name , String debut_date , short height) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.debut_date = debut_date;
		this.height = height;
	}
	
	DTO(String mem_id,String mem_name) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
	}
	
	DTO(String mem_name,short height) {
		this.mem_name = mem_name;
		this.height = height;
	}
	
	DTO(String mem_name,short height,int mem_number){
		this.mem_name = mem_name;
		this.height = height;
		this.mem_number = mem_number;
	}
	
	DTO(String mem_id, String mem_name, int mem_number, String addr, String phone1, String phone2, short height,
			String debut_date) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_number = mem_number;
		this.addr = addr;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.height = height;
		this.debut_date = debut_date;
	}	
}