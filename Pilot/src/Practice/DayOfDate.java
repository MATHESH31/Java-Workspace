package Practice;

import java.util.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class DayOfDate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int day = in.nextInt();
		int month = in.nextInt();
		int year = in.nextInt();
		LocalDate l = LocalDate.of(year,month,day);
		DayOfWeek Day = l.getDayOfWeek();
		
		System.out.println(Day);
		in.close();
		
	}

}
