package org.sealoflove.zero.one;

import org.sealoflove.Task;

public class Task019 implements Task {

	
	int months[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int monthsLeap[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	boolean isLeap(int year) {
		if (year % 4 == 0) {
			if (((year % 100 == 0) && (year % 400 == 0)) || (year % 100 != 0))
				return true;
		}
		return false;
	}
	
	private int iterateDates() {
		int res = 0;
		int year = 1900;
		int month = 1;
		int day = 1;
		int dayOfWeek = 1;
		

		int myMonths[] = months;
		while (year < 2001) {
			day++;
			dayOfWeek++;
			if (dayOfWeek > 7)
				dayOfWeek = 1;
			if (day > myMonths[month]) {
				month++;
				day = 1;
				//------
				//------
				if (month > 12) {
					month = 1;
					year++;
					if (year == 1901)
						res = 0;
					if (isLeap(year))
						myMonths = monthsLeap;
					else 
						myMonths = months;
				}
			}
			if (day == 1 && dayOfWeek == 7)
				res++;
			System.out.println(String.format("%d %d %d %d", day, month, year, dayOfWeek));
		}
		return res;
	}
	
	
	@Override
	public String getResult() {
		return String.format("%d", iterateDates());
	}

}
