package model.dao;

import java.util.ArrayList;

import model.dto.boardDto;

public class boardDao extends Dao{
	private static boardDao bdao = new boardDao();
	public static boardDao getInstance() {return bdao;}
	
	public boolean board(String title , String cont , int mnum) {
		String sql = "insert into board(btitle,bcon,mnum) values(?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, cont);
			ps.setInt(3, mnum);
			ps.executeUpdate();			
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean board2(String title , String cont , int mnum , String bfile) {
		String sql = "insert into board(btitle,bcon,mnum,bfile) values(?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, cont);
			ps.setInt(3, mnum);
			ps.setString(4, bfile);
			ps.executeUpdate();			
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean bupdate(String title , String cont , int bnum , String bfile) {
		String sql = "update board set btitle=? , bcon=? ,bfile=? where bnum=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, cont);
			ps.setString(3, bfile);
			ps.setInt(4,bnum);
			ps.executeUpdate();			
			return true;
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	public ArrayList<boardDto> boardlist(int startrow , int listsize, String key , String keyword) {
		ArrayList<boardDto> list = new ArrayList<>();
		String sql = "";
		
		if(!key.equals("") && !keyword.equals("")) {
			sql= "select b.* , m.mid from member m, board b where m.mnum=b.mnum and "+key+" like '%"+keyword+"%' order by bdate desc limit ?,?;";
		}
		else {
			sql = "select b.* , m.mid from member m, board b where m.mnum=b.mnum order by bdate desc limit ?,?;";
		}
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs = ps.executeQuery();
			while(rs.next()) {
				boardDto dto = new boardDto(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getString(9)
						);
				list.add(dto);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	public boolean bdelete(String bnum , int mnum) {
		String sql = "delete from board where bnum=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bnum);
			int count = ps.executeUpdate();			
			if(count==1) {return true;}
		} 
		catch (Exception e) {System.out.println(e);}
		return false;
	}

	
	public boardDto bdetail(int bnum) {
		boardDto dto = null ;
		String sql = "update board set bview = bview+1  where bnum=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			int count = ps.executeUpdate();			
			if(count==1) {
				String sql1 = "select b.* , m.mid from member m, board b where m.mnum=b.mnum and bnum=?;";
				try {
					ps = con.prepareStatement(sql1);
					ps.setInt(1, bnum);
					rs=ps.executeQuery();
					if(rs.next()) {
						dto = new boardDto(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getInt(8),
								rs.getString(9)
								);
						return dto;
					}
					return dto;
				} 
				catch (Exception e) {System.out.println(e);}
				return dto;
			}
		} 
		catch (Exception e) {System.out.println(e);}
		return dto;
	}
	
	public int gettotalsize() {
		String sql = "select count(*) from board;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	
	
}
