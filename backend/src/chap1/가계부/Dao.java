package chap1.가계부;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static Dao adao = new Dao();
	
	//생성자
	private Dao(){//싱글톤
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/money", 
				"root", 
				"1234");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//메소드
	public static Dao getinstance(){return adao;} 
	
	//기능메소드
	//추가하기
	boolean inMenu(String date,int price,String content) {
		String sql ="insert into number values(null,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, date); //1번째물음표에
			ps.setInt(2, price);
			ps.setString(3, content);
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	//불러오기
	ArrayList<Dto> getMenu(int page) {
		ArrayList<Dto> list = new ArrayList<>();
		String sql ="SELECT * FROM number ORDER BY m_num DESC LIMIT ?,3;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,page);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto menu = new Dto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				list.add(menu);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	
	boolean delMenu(int M_num) {
		String sql ="delete from number where m_num like ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, M_num); //1번째물음표에
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	boolean updateMenu(int M_num,String date,int price,String content) {
		String sql ="update number set m_date=? , price=? , content=? where m_num=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,date);
			ps.setInt(2, price); //1번째물음표에
			ps.setString(3,content);
			ps.setInt(4,M_num);
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	ArrayList<Dto> searchdate(String date) {
		ArrayList<Dto> list = new ArrayList<>();
		String sql ="select * from number where m_date=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,date);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto menu = new Dto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				list.add(menu);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	ArrayList<Dto> statistics() {
		ArrayList<Dto> list = new ArrayList<>();
		String sql ="select m_date , sum(price)as 수량합계 from number group by m_date;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto menu = new Dto(rs.getString(1),rs.getInt(2));
				list.add(menu);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
