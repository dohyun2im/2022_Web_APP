package chap1.ch10예외처리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	private Dao(){
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardtest", 
					"root", 
					"1234");		 
		}  
		catch (Exception e) {
			System.out.println("DB접속 실패"+e);
		}
	}
	
	public void signUp() throws SQLException{
		String sql = "";
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
	
	public void login() throws SQLException{
		String sql = "";
		ps = con.prepareStatement(sql);
		ps.executeQuery();
	} 
}
