package database.자바연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC실행2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop_db1",
					"root",
					"1234");
			System.out.println("db 성공");
			/*
			String sql = "insert into product values('바나나','1500','2021-07-01','델몬트','17')";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
			String sql1 = "insert into product values('카스','2500','2022-03-01','OB','3')";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.executeUpdate();
			
			String sql2 = "insert into product values('삼각김밥','800','2023-09-01','CJ','22')";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.executeUpdate();
				
			String sql = "update product set amount = 10 where product_name = '카스' ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
			String sql1 = "delete from product where product_name='삼각김밥' ";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.executeUpdate();
			*/
			
			String sql = "select * from shop_db1.product" ;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				System.out.print("상품명 : "+rs.getString(1)+"\t ");
				System.out.print("가격 : "+rs.getInt(2)+"\t");
				System.out.print("유통기한 : "+rs.getString(3)+"\t");
				System.out.print("제조사 : "+rs.getString(4)+"\t");
				System.out.print("수량 : "+rs.getInt(5)+"\n");
			}
			
		} 
		catch (Exception e) {
			System.out.println("db 실패"+e);	
		}
	}
}
