package model.dao;

import java.util.ArrayList;

import model.dto.commentDto;

public class commentDao extends Dao{
	private static commentDao cdao = new commentDao();
	public static commentDao getInstance() {return cdao;}
	//댓글작성
	public boolean comment(int mnum , int bnum , String comment) {
		String sql = "insert into comments(mno,bno,bcon) values(?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			ps.setInt(2, bnum);
			ps.setString(3, comment);
			ps.executeUpdate();		
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	//대댓글작성
		public boolean cocomment(int mnum , int bnum , String comment,int cindex) {
			String sql = "insert into comments(mno,bno,bcon,cindex) values(?,?,?,?);";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, mnum);
				ps.setInt(2, bnum);
				ps.setString(3, comment);
				ps.setInt(4, cindex);
				ps.executeUpdate();		
				return true;
			} catch (Exception e) {System.out.println(e);}
			return false;
		}	
	
	
	
	//댓글가져오기
	public ArrayList<commentDto> comlist(int bnum) {
		ArrayList<commentDto> list = new ArrayList<>();
		String sql = "select c.*,m.mid from comments c,member m where m.mno=c.mno and bno=? and cindex=0 order by c.bdate desc;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			while(rs.next()) {
				commentDto dto = new commentDto(
						rs.getString(7),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(1));
				list.add(dto);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	//대댓글가져오기
	public ArrayList<commentDto> comcomlist(int bnum,int cindex) {
		ArrayList<commentDto> list = new ArrayList<>();
		String sql = "select c.*,m.mid from comments c,member m where m.mno=c.mno and bno=? and cindex=? order by c.bdate desc;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			ps.setInt(2, cindex);
			rs = ps.executeQuery();
			while(rs.next()) {
				commentDto dto = new commentDto(
						rs.getString(7),
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(1));
				list.add(dto);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
}
