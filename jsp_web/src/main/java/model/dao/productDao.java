package model.dao;

import java.util.ArrayList;

import model.dto.categoryDto;
import model.dto.productDto;

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
	public ArrayList<productDto> getproductlist(){
		String sql = "select * from product;";
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
}













