package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.dto.cartDto;
import model.dto.categoryDto;
import model.dto.orderDto;
import model.dto.productDto;
import model.dto.stockDto;

public class productDao extends Dao{
	
	
	//카테고리저장
	public boolean setpcategory(String pcname) {
		String sql = "insert into pcategory(pcname) value(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pcname);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//카테고리출력
	public ArrayList<categoryDto> getpcategory(){
		ArrayList<categoryDto> list = new ArrayList<>();
		categoryDto dto = null;
		String sql = "select * from pcategory;";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				dto = new categoryDto(rs.getInt(1),rs.getString(2));
				list.add(dto);
			}
			return list;
		} 
		catch (Exception e) {System.out.println(e);
		}
		return null;
	}
	
	//제품등록
	public boolean setproduct(productDto dto) {
		String sql = "insert into product(pname,pcomment,pprice,pdiscount,pimg,pcno) values(?,?,?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,dto.getPname());
			ps.setString(2,dto.getPcomment());
			ps.setInt(3,dto.getPprice());
			ps.setFloat(4,dto.getPdiscount());
			ps.setString(5,dto.getPimg());
			ps.setInt(6,dto.getPcno());
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//제품출력
	public ArrayList<productDto> getproductlist(String option){
		String sql = null;
		if(option.equals("all")) {
			sql = "select * from product;";
		}
		else if(option.equals("pactive1")) {
			sql = "select * from product where pactive=1 order by pdate desc;";
		}
		
		ArrayList<productDto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				productDto dto = new productDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getFloat(5),
						rs.getByte(6),
						rs.getString(7),
						rs.getString(8),
						rs.getInt(9));
				list.add(dto);
			}
			return list;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//개별출력 getproduct
	public productDto getproduct(int pno){
		String sql = "select * from product where pno= "+pno;
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			if(rs.next()) {
				productDto dto = new productDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getFloat(5),
						rs.getByte(6),
						rs.getString(7),
						rs.getString(8),
						rs.getInt(9));
				return dto;
			}	
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//제품삭제
	public boolean deleteproduct(int pno) {
		String sql = "delete from product where pno="+pno;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count==1) {
				return true;
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//제품수정
		public boolean updateproduct(productDto dto) {
			String sql = "update product set pname=? , pcomment=? , pprice=? , pdiscount=? , pactive=? , pimg=? , pcno=? where pno=?;";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getPname());
				ps.setString(2,dto.getPcomment());
				ps.setInt(3,dto.getPprice());
				ps.setDouble(4,dto.getPdiscount());
				ps.setByte(5,dto.getPactive());
				ps.setString(6,dto.getPimg());
				ps.setInt(7,dto.getPcno());
				ps.setInt(8,dto.getPno());
				int count = ps.executeUpdate();
				if(count==1) {
					return true;
				}
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
		
		public boolean setstock(String psize,int pno,String pcolor,int pstock) {
			String sql = "insert into productsize(psize,pno) values(?,?);";
			try {
				ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, psize);
				ps.setInt(2, pno);
				ps.executeUpdate();
				rs=ps.getGeneratedKeys();
				if(rs.next()) {
					int psno = rs.getInt(1);
					sql = "insert into productstock(pcolor,pstock,psno) values(?,?,?);";
					ps=con.prepareStatement(sql);
					ps.setString(1,pcolor);
					ps.setInt(2, pstock);
					ps.setInt(3,psno);
					ps.executeUpdate();
					return true;
				}
				
			} 
			catch (Exception e) {System.out.println(e);}
			return false;
		}
		public ArrayList<stockDto> getstock(int pno){
			ArrayList<stockDto> list = new ArrayList<>();
			String sql = "select ps.psno , ps.psize , pst.pstno , pst.pcolor , pst.pstock from productsize ps , productstock pst where ps.psno=pst.psno and ps.pno="+pno+" order by ps.psize desc;";
			try {
				ps = con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					stockDto dto = new stockDto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
					list.add(dto);
				}
				return list;
			} 
			catch (Exception e) {System.out.println(e);}
			return null;
		}
		
		public int setplike (int pno , int mno) {
			String sql = "select * from plike where pno=? and mno=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				rs = ps.executeQuery();
				if(rs.next()) {
					sql = "delete from plike where pno=? and mno=?";	
					ps = con.prepareStatement(sql);
					ps.setInt(1, pno);
					ps.setInt(2, mno);
					ps.executeUpdate();
					return 1;
				}
				else {
					sql = "insert into plike(pno,mno) values(?,?)";
					ps = con.prepareStatement(sql);
					ps.setInt(1, pno);
					ps.setInt(2, mno);
					ps.executeUpdate();
					return 2;
				}
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			return 3;
		}
		
		public boolean setcart(int mno , int pno, String size, int amount , String color) {
			String sql = "insert into cart (amount , pstno , mno) values("+
					"	"+amount+","+
					"	(select pstno from productstock pst , (select psno from productsize where pno="+pno+" and psize='"+size+"') sub where pst.psno=sub.psno and pcolor = '"+color+"'),"+
					" "+mno+""+
					");";
			try {
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
		public ArrayList<cartDto> getcart(int mno){
			ArrayList<cartDto> list = new ArrayList<>();
			String sql ="select c.cartno, c.pstno,p.pname,p.pimg, p.pprice , p.pdiscount, pst.pcolor, ps.psize,c.amount "
						+ " from cart c natural join productstock pst natural join productsize ps natural join product p "
						+ " where c.mno = ? ;";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, mno);
				rs = ps.executeQuery();
				while(rs.next()) {
					cartDto dto = new cartDto(
							rs.getInt(1),
							rs.getInt(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5),
							rs.getFloat(6),
							rs.getString(7),
							rs.getString(8),
							rs.getInt(9));
					list.add(dto);
				}
				return list;
			} 
			catch (Exception e) {
				System.out.println(e); 
			}
			return null;
		}
		
		public boolean setorder(ArrayList<orderDto> list) {
			String oname = list.get(0).getOname();
			String ophone = list.get(0).getOphone();
			String oaddr = list.get(0).getOaddr();
			String orequest = list.get(0).getOrequest();
			int mno = list.get(0).getMno();
			
			String sql = "insert into porder(oname,ophone,oaddr,orequest,mno) values(?,?,?,?,?);";
			try {
				ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,oname);
				ps.setString(2,ophone);
				ps.setString(3,oaddr);
				ps.setString(4,orequest);
				ps.setInt(5, mno);
				ps.executeUpdate();
				rs=ps.getGeneratedKeys();
				if(rs.next()) {
					int ono = rs.getInt(1);
					
					for(orderDto dto : list) {
						sql = "insert into porderdetail(odamount,odprice,odactive,pstno,ono) values(?,?,?,?,?);";
						ps=con.prepareStatement(sql);
						ps.setInt(1,dto.getOdamount());
						ps.setInt(2, dto.getOdprice());
						ps.setInt(3,dto.getOdactive());
						ps.setInt(4,dto.getPstno());
						ps.setInt(5,ono);
						ps.executeUpdate();
					}					
				}
				return true;
			} 
			catch (Exception e) {System.out.println(e);}
			return false;
		}
}













