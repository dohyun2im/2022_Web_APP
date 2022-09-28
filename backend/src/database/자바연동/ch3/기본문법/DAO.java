package database.자바연동.ch3.기본문법;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
import java.util.ArrayList;




	public class DAO {
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
	
		
	public DAO() {
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/market_db", 
				"root", 
				"1234");
		} 
		catch (Exception e) {
			System.out.println("db 실패"+e);
		}		
	}
	
	
	
	public ArrayList<DTO> 예제1결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select * from member;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2) ,
					rs.getInt(3) ,
					rs.getString(4) ,
					rs.getString(5) ,
					rs.getString(6) ,
					rs.getShort(7) ,
					rs.getString(8));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	
	ArrayList<String> 예제2결과() {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select mem_name from member;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	DTO 예제3결과() {
		String sql = "select * from member where mem_name ='블랙핑크';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				if(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2) ,
					rs.getInt(3) ,
					rs.getString(4) ,
					rs.getString(5) ,
					rs.getString(6) ,
					rs.getShort(7) ,
					rs.getString(8));
					return dto;
				}
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	public ArrayList<DTO> 예제4결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = " select mem_id , mem_name from member where height <= 162;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제5결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_name , height , mem_number from member where height >= 165 and mem_number > 6;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getShort(2) ,
					rs.getInt(3));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제6결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_name , height , mem_number from member where height >= 165 or mem_number > 6;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getShort(2) ,
					rs.getInt(3));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제7결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select * from member where mem_name like '우%';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2) ,
					rs.getInt(3) ,
					rs.getString(4) ,
					rs.getString(5) ,
					rs.getString(6) ,
					rs.getShort(7) ,
					rs.getString(8));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제8결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select * from member where mem_name like '__핑크';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2) ,
					rs.getInt(3) ,
					rs.getString(4) ,
					rs.getString(5) ,
					rs.getString(6) ,
					rs.getShort(7) ,
					rs.getString(8));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제9결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id , mem_name , debut_date from member order by debut_date desc;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2) ,
					rs.getString(3));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제10결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id , mem_name , debut_date , height from member where height >= 164 order by height desc ;"
				+ "";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2) ,
					rs.getString(3) ,
					rs.getShort(4) );
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제11결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id , mem_name , debut_date , height from member where height >= 164 order by height desc , debut_date asc;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getString(2) ,
					rs.getString(3) ,
					rs.getShort(4) );
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제12결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = " select mem_name , height  from member order by height desc limit 3 , 2 ;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getShort(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	ArrayList<String> 예제13결과() {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select distinct addr from member;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제14결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id , sum(amount) as 수량합계 from buy group by mem_id;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getInt(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제15결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id as 회원_아이디 , sum( price*amount )  as 총_구매금액 from buy group by mem_id;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getInt(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제16결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id , avg( amount ) as 수량평균 from buy group by mem_id;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getInt(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제17결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id , count( phone1 ) as 연락처 from member group by mem_id;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getInt(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제18결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id , count( * ) as 회원수 from member group by mem_id;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getInt(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public ArrayList<DTO> 예제19결과() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select mem_id as 회원아이디 , sum( price * amount ) as 총구매금액 from buy group by mem_id having sum( price * amount ) > 1000 order by sum( price * amount ) desc;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				while(rs.next()) {
					DTO dto = new DTO(
					rs.getString(1) ,
					rs.getInt(2));
				list.add(dto);
				}
			return list;
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	
}