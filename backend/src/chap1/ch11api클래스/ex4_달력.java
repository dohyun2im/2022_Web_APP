package chap1.ch11api클래스;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ex4_달력 {	
	Scanner sc = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	int year = 	cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int day = 	cal.get(Calendar.DAY_OF_MONTH);
		
	void run() {	
		while(true) {
			//일정출력
			ArrayList<ex4_달력Dto> list = 일정출력();
			System.out.println("===================== Todolist =====================");
			for(ex4_달력Dto a : list) {
				System.out.print(a.getNum()+"\t");
				System.out.print(a.getMm()+"\t");
				System.out.print(a.getMemo()+"\n");
			}
			//1일로 세팅하기
			cal.set(year, month-1, 1);
			
			//1일 요일찾기
			int sWeek = cal.get(Calendar.DAY_OF_WEEK);
			
			//마지막 일 찾기
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
			//출력		
			System.out.printf("==================%d년 %d월의 달력 ===================\n",year , month );
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			for(int i=1 ; i< sWeek ; i++) {
				System.out.print("없음\t");
			}

			
			for(int i=1; i<=eday; i++) {
				for(ex4_달력Dto a : list) {
					String[] arr =a.getMm().split("-");
					if(Integer.parseInt(arr[0])==year && 
					   Integer.parseInt(arr[1])==month && 
					   Integer.parseInt(arr[2])==i) {System.out.print("*");}
				}
				System.out.print(i+"\t");
				if((sWeek)%7==0) {System.out.print("\n");}
				sWeek++;
			}
			System.out.println();
			System.out.println("====================================================");
		
			//메뉴
			System.out.println("1)이전달   2)다음달    3)검색    4)일정추가"); int ch = sc.nextInt();
			if(ch==1) {month--;
				if(month==0) {
					month=12; year--;
				}
			}
			else if(ch==2) {month++;
				if(month==13) {
					month=1; year++;
				}
			}
			else if(ch==3) {
				System.out.println("yyyy년 연도 입력 ? :"); int yy = sc.nextInt();
				System.out.println("mm월 월을 입력 ? :");	 int mm = sc.nextInt();
				if(yy<1900||yy>2100 && mm<1 || mm>12) {
					System.err.println("잘못된 입력");
				}
				else {year=yy; month=mm;}			
			}
			else if(ch==4) {
				System.out.println("yyyy-mm-dd 입력:"); String mm = sc.next();
				sc.nextLine();
				System.out.println("일정 메모 :"); String memo = sc.nextLine();
				일정추가(mm,memo);}
		}
	}
	
	
	boolean 일정추가(String mm,String memo){
	return ex4_달력DAO.getinstance().일정추가(mm, memo);
	}
	
	
	ArrayList<ex4_달력Dto> 일정출력(){
		return ex4_달력DAO.getinstance().일정출력();
	}
	
	
	
	
	
	
	
	
	
}
