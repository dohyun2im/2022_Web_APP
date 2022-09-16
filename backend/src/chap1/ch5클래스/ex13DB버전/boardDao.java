package chap1.ch5클래스.ex13DB버전;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class boardDao {
	Connection con;         //db 접속 DriverManager.getConnection db주소 , db계정명 , 비밀번호
	PreparedStatement ps;   //db에 sql연결조작
	ResultSet rs;			//sql결과조작
	
	
	//db연결
	boardDao(){
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardtest", 
					"root", 
					"1234");		
		} 
		catch (Exception e) {
			System.out.println("DB접속 실패"+e);
		}
	}
	
	
	//등록
	boolean regist(boardDto boardDto){
		//sql 작성
		String sql = "insert into boardtest.board( b_title , b_content , b_writer , b_password , b_view) values(?,?,?,?,?);";
		
		try {
			ps = con.prepareStatement(sql);  //sql 연결조작
				ps.setString(1, boardDto.b_title);
				ps.setString(2, boardDto.b_content);
				ps.setString(3, boardDto.b_writer);
				ps.setString(4, boardDto.b_password);
				ps.setInt(5,0);
			ps.executeUpdate();              //sql 결과
			return true;
		} 
		catch (Exception e) {
			System.out.println("DB 전송 오류"+e);
		}
		return false;
	}
	
	//전체게시물 수 구하는 메소드
	int getRows() {
		String sql = "select count(*) from boardtest.board;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
		} 
		catch (Exception e) {
			System.out.println("게시물수 구하기 실패"+e);
		}
		
		return 0 ;
	}
	
	
	//모든 게시물 출력
	boardDto[] getBoardlist(){
		int count = getRows();
		boardDto[] boardlist=new boardDto[count];
		String sql = "select * from  boardtest.board;";
		try {
			ps = con.prepareStatement(sql); //연결
			rs = ps.executeQuery(); //쿼리가져오기
			int index = 0;
			while(rs.next()) { //다음레코드까지 무한반복
				int b_num = rs.getInt(1); // 1레코드 1필드
				String b_title = rs.getString(2);
				String b_content = rs.getString(3);
				String b_writer = rs.getString(4);
				String b_password =rs.getString(5);
				int b_view =rs.getInt(6);
				boardDto board = new boardDto(b_num,b_title,b_content,b_writer,b_password,b_view);
				boardlist[index]=board;
				index++;
			}
		}
		catch (Exception e) {
			System.out.println("가져오기 실패"+e);
		}
		return boardlist;
	}
	
	
	//개별 게시물 출력
	boardDto getBoard(int b_num){
		boardDto board = null;
		String sql = "select * from boardtest.board where b_num=?;";
		try {
			ps=con.prepareStatement(sql);
				ps.setInt(1, b_num);
			rs=ps.executeQuery();
			if(rs.next()) {
				board =new boardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) , rs.getString(5), rs.getInt(6));
				
			}
			
		} 
		catch (Exception e) {
			System.out.println("가져오기 실패"+e);
		}
		
		return board;
	}
	
	
	//수정
	boolean update(int b_num , String b_password , String new_title , String new_content){
		
		return false;
	}
	
	
	
	//삭제
	boolean delete(int b_num , String b_password){
		return false;
	}
	
	
}
