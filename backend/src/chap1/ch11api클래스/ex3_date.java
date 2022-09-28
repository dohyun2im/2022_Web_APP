package chap1.ch11api클래스;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ex3_date {
	public static void main(String[] args) {
		Date now = new Date();			System.out.println(now);
		String strnow = now.toString(); System.out.println(strnow);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strnow1 = sdf.format(new Date() ); System.out.println(strnow1);
		
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR); 	   System.out.println(year);
		int month = cal.get(Calendar.MONTH)+1; System.out.println(month);
		int day = cal.get(Calendar.DAY_OF_MONTH); System.out.println(day);
		int week = cal.get(Calendar.DAY_OF_WEEK); 
		String strweek = null;
		switch(week) {
			case Calendar.MONDAY : strweek = "월"; break;
			case Calendar.TUESDAY : strweek = "화"; break;
			case Calendar.WEDNESDAY : strweek = "수"; break;
			case Calendar.THURSDAY : strweek = "목"; break;
			case Calendar.FRIDAY : strweek = "금"; break;
			case Calendar.SATURDAY : strweek = "토"; break;
			default:  strweek = "일"; break;
		}
		System.out.println(strweek);
		int amPm = cal.get(Calendar.AM_PM);
		if(amPm==0) {
			System.out.println("오전입니다.");
		}
		else {System.out.println("오후입니다.");}
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		ex4_달력 ex = new ex4_달력();
		ex.run();
	}
}
