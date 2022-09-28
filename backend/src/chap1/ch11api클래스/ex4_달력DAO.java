package chap1.ch11api클래스;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import chap1.가계부.Dao;
import chap1.가계부.Dto;

public class ex4_달력DAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static ex4_달력DAO adao = new ex4_달력DAO();
	
	private ex4_달력DAO(){//싱글톤
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/todolist", 
				"root", 
				"1234");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//메소드
	public static ex4_달력DAO getinstance(){return adao;} 
	
	//기능구현
	
	//일정추가
	boolean 일정추가(String mm,String memo){
		String sql ="insert into number values(null,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mm); //1번째물음표에
			ps.setString(2, memo);
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	//일정출력
	ArrayList<ex4_달력Dto> 일정출력(){
		ArrayList<ex4_달력Dto> list = new ArrayList<>();
		String sql ="SELECT * FROM number;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ex4_달력Dto menu = new ex4_달력Dto(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(menu);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;	
	}
	
	//일정출력
		ArrayList<ex4_달력Dto> 일정출력1(String year , String month){
			ArrayList<ex4_달력Dto> list = new ArrayList<>();
			String sql ="select * from number where substring(t_date ,1,4) ='?' and substring(t_date ,6,2) = '?';";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, year);
				ps.setString(1, month);
				rs = ps.executeQuery();
				while(rs.next()) {
					ex4_달력Dto menu = new ex4_달력Dto(rs.getInt(1),rs.getString(2),rs.getString(3));
					list.add(menu);
				}
				return list;
			} 
			catch (Exception e) {System.out.println(e);}
			return list;	
		}
	
	
	
	
	
	
	
}
