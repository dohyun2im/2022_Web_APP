package chap1.가계부;

import java.util.ArrayList;

public class Controller {
	boolean inMenu(String date,int price,String content) {
		return Dao.getinstance().inMenu(date, price, content);
	}
	
	//카테고리보기
	ArrayList<Dto> getMenu(int page){
		return Dao.getinstance().getMenu(page);
	}
	
	boolean delMenu(int M_num) {
		return Dao.getinstance().delMenu(M_num);
	}
	boolean updateMenu(int M_num,String date,int price,String content) {
		return Dao.getinstance().updateMenu(M_num,date,price,content);
	}
	
	
	ArrayList<Dto> searchdate(String date) {
		return Dao.getinstance().searchdate(date);
	}
	
	
	ArrayList<Dto> statistics() {
		return Dao.getinstance().statistics();
	}
}
