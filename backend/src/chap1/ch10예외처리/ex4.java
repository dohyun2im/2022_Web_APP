package chap1.ch10예외처리;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex4 {
	public static void signUp() throws SQLException{
		Dao.getInstance().signUp();
	}
	
	public static void login() throws SQLException{
		Dao.getInstance().login();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("1.회원가입 2.로그인");
				int ch = sc.nextInt();
				if(ch==1) {signUp();}
				else if(ch==2) {login();}		
			} 
			catch (SQLException e) {
				System.out.println("오류 " + e);
			}
			catch(InputMismatchException e) {
				System.out.println("숫자만 입력하세요");
				sc = new Scanner(System.in);
			}
			catch (Exception e) {
				System.out.println("예상치 못한 오류 초기화면으로 .. " + e);
			}
		}
	}
}
