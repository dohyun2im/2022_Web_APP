package database.자바연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class JDBC실행 {
	public static void main(String[] args) {
		// 라이브러리 필요
		// 라이브러리 추가
		// 연결안되면 ? try ~ catch
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/shop_db1",
				"root",
				"1234");
		System.out.println("db 성공");
		//테이블에 데이터추가
		/*
		String sql1 = "insert into member values('iyou','아이유','콘서트')";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.executeUpdate();
		
		String sql2 = "insert into member values('jyp','박진영','사옥')";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.executeUpdate();
		
		//박진영 변경
		String sql2 = "update member set member_addr = '경기도 안산시 상록구' where member_id='jyp'";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.executeUpdate();
		}
		
		String sql2 = "delete from member where member_id='iyou'";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.executeUpdate();
		
		*/
		//모든 멤버 호출
		String sql = "select * from shop_db1.member" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs =  ps.executeQuery();
		while(rs.next()) {
			System.out.print("회원 아이디 : "+rs.getString(1)+"\t ");
			System.out.print("회원명 : "+rs.getString(2)+"\t");
			System.out.print("회원주소 : "+rs.getString(3)+"\n");
		}
		
		}
		catch(Exception e){
		System.out.println("db 실패"+e);
		}
	}
}
