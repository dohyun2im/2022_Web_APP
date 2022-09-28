package chap1.키오스크.관리자;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static AdminDao adao = new AdminDao();
	
	//생성자
	private AdminDao(){//싱글톤
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mommoth", 
				"root", 
				"1234");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
		
	//메소드
	public static AdminDao getinstance(){return adao;} 
	
	
	//기능메소드
	
	//메뉴추가
	boolean addMenu(String mname) {
		String sql ="insert into category values(null,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname); //1번째물음표에
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	//메뉴호출
	ArrayList<MenuDto> getMenu() {
		ArrayList<MenuDto> list = new ArrayList<>();
		String sql ="select * from category;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MenuDto menu = new MenuDto(rs.getInt(1),rs.getString(2));
				list.add(menu);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	  
	//제품추가
	boolean addProd(ProductDto pd) {  
		String sql ="insert into product values(?,null,?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pd.getMno()); //1번째물음표에
			ps.setString(2, pd.getPname());
			ps.setInt(3, pd.getPprice());
			ps.setInt(4, pd.getPamount());
			ps.setString(5, pd.getPcomment());
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
		
		
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
