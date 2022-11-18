package model.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dto.boardDto;

public class boardDao extends Dao{
	private static boardDao bdao = new boardDao();
	public static boardDao getInstance() {return bdao;}
	
	public boolean board(String title , String cont , int mnum) {
		String sql = "insert into board(btitle,bcon,mno) values(?,?,?);";
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
		String sql = "insert into board(btitle,bcon,mno,bfile) values(?,?,?,?);";
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
		String sql = "update board set btitle=? , bcon=? ,bfile=? where bno=?;";
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
			sql= "select b.* , m.mid from member m, board b where m.mno=b.mno and "+key+" like '%"+keyword+"%' order by bdate desc limit ?,?;";
		}
		else {
			sql = "select b.* , m.mid from member m, board b where m.mno=b.mno order by bdate desc limit ?,?;";
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
		String sql = "delete from board where bno=?;";
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
		String sql = "update board set bview = bview+1  where bno=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			int count = ps.executeUpdate();			
			if(count==1) {
				String sql1 = "select b.* , m.mid from member m, board b where m.mno=b.mno and bno=?;";
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
	
	public JSONArray getapi() {
		JSONArray array = new JSONArray();
		String sql ="select * from 아파트매매실거래가 where 시군구 like '%강남%';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("시군구", rs.getString(1));
				object.put("번지본번부번", rs.getString(2) +"/"+ rs.getInt(3)+"/"+rs.getInt(4));
				object.put("단지명", rs.getString(5));
				object.put("전용면적", rs.getDouble(6));
				object.put("계약년월", rs.getInt(7));
				object.put("계약일", rs.getInt(8));
				object.put("거래금액", rs.getString(9));
				object.put("층", rs.getInt(10));
				object.put("건축년도", rs.getInt(11));
				object.put("도로명", rs.getString(12));
				object.put("해제사유발생", rs.getString(13));
				object.put("거래유형", rs.getString(14));
				object.put("중개사", rs.getString(15));
				array.add(object);
			}
		} 
		catch (Exception e) {System.out.println(e);}
		return array;
	}
	
	
	
}
