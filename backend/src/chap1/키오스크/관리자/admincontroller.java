package chap1.키오스크.관리자;

import java.util.ArrayList;

public class admincontroller {
	//카테고리등록
	boolean inMenu(String mname) {
		return AdminDao.getinstance().addMenu(mname);
	}
	
	//카테고리보기
	ArrayList<MenuDto> getMenu(){
		return AdminDao.getinstance().getMenu();
	}
	//상품등록
	boolean inProduct(int mno,String pname,int pprice,String pcomment,int pamount){
		ProductDto pd = new ProductDto(pname, pprice, pcomment, pamount, mno);
		return AdminDao.getinstance().addProd(pd);
	}
	
	void getOrder() {}
	
}
