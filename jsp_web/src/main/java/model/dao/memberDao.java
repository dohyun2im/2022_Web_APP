package model.dao;

import java.util.ArrayList;

import model.dto.boardDto;
import model.dto.memberDto;

public class memberDao extends Dao{
	
	private static memberDao mdao = new memberDao();
	public static memberDao getInstance() {return mdao;}
	
	public boolean signup(memberDto dto) {
		String sql = "insert into member(mid,mpw,mname,mpn,memail,maddr) values(?,?,?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMpn());
			ps.setString(5, dto.getMemail());
			ps.setString(6, dto.getMaddr());
			ps.executeUpdate();			
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public String findid (String mname, String memail) {
		String sql = "select *from member where mname=? and memail=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(2);
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public boolean findpw (String mid, String memail) {
		String sql = "select *from member where mid=? and memail=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean pwchange(String mid ,String randstr) {
		String sql = "update member set mpw = ? where mid = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, randstr);
			ps.setString(2, mid);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
		}return false;
	}
	
	public memberDto getinfo(String mid) {
		memberDto dto = null;
		String sql = "select * from member where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new memberDto();
				dto.setMnum(rs.getInt(1));
				dto.setMid(rs.getString(2));
				dto.setMname(rs.getString(4));
				dto.setMpn(rs.getString(5));
				dto.setMemail(rs.getString(6));
				dto.setMaddr(rs.getString(7));
				dto.setMdate(rs.getString(8));
				dto.setMpoint(rs.getInt(9));	
				return dto;
			}
		} 
		catch (Exception e) {}
		return dto;		
	}
	
	
	
	public ArrayList<memberDto> getinfolist(){
		ArrayList<memberDto> list = new ArrayList<>();
		String sql = "select * from member;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
			memberDto dto = new memberDto(
					rs.getInt(1),
					rs.getString(2),
					null,
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getInt(9)
					);
			  list.add(dto);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e+"info");}
		return list;
	}
	
	//회원탈퇴
	public boolean delete(String mid , String mpassword) {
		String sql = "delete from member where mid=? and mpw=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpassword);
			int count = ps.executeUpdate();
			if(count==1) {return true;}		
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}

	public boolean idcheck(String mid) {
		String sql = "select * from member where mid=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean emailcheck(String memail) {
		String sql = "select * from member where memail=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	public boolean update(String mid , String mname) {
		String sql = "update member set mname=? where mid=? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mid);
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public int getMnum( String mid) {
		String sql = "select mno from member where mid = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			rs = ps.executeQuery();
			if( rs.next() ) return rs.getInt(1);
		}catch (Exception e) { System.out.println(e);} return 0;	
	}
	
	
	
	
	
	
	
	
	
	
	
}
