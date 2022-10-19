package model.dao;

import model.dto.loginDto;

public class loginDao extends Dao{
	private static loginDao mdao = new loginDao();
	public static loginDao getInstance() {return mdao;}
	
	public boolean login(loginDto dto) {
		String sql = "select mid , mpw from member where mid=? and mpw=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			rs=ps.executeQuery();
			if(rs.next()) {
				if(dto.getMid().equals(rs.getString(1)) && 
				   dto.getMpw().equals(rs.getString(2)) ){
					return true;
				}
			}
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
}
