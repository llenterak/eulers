package org.sealoflove.euler.two;

import java.util.HashMap;
import java.util.Map;

import org.sealoflove.euler.Task;

public class Task017 implements Task {

	
	private Map<String, Integer> totals = new HashMap<String, Integer>();
	private int countOfAnds = 0;
	
	
	@SuppressWarnings("serial")
	Map<Integer, String> numbers = new HashMap<Integer, String>() {{
		put(1, "one");
		put(2, "two");
		put(3, "three");
		put(4, "four");
		put(5, "five");
		put(6, "six");
		put(7, "seven");
		put(8, "eight");
		put(9, "nine");
		put(10, "ten");
		put(11, "eleven");
		put(12, "twelve");
		put(13, "thirteen");
		put(14, "fourteen");
		put(15, "fifteen");
		put(16, "sixteen");
		put(17, "seventeen");
		put(18, "eighteen");
		put(19, "nineteen");
		put(20, "twenty");
		put(30, "thirty");
		put(40, "forty");
		put(50, "fifty");
		put(60, "sixty");
		put(70, "seventy");
		put(80, "eighty");
		put(90, "ninety");
		put(100, "hundred");
		put(1000, "thousand");
	}};
	
	
	private void add(String number) {
		Integer res = totals.get(number);
		if (res != null) {
			totals.put(number, res + 1);
		} else 
			totals.put(number, 1);
	}
	
	private void addNumberToTotals(int number) {
		 if ((number > 1000) || (number < 1))
			 return;
		 if (number == 1000) {
			 add("one");
			 add("thousand");
			 return;
		 }
		 String out = "";
		 if ((number > 100) && (number % 100 != 0))
			 countOfAnds++;
		 
		 
		 int units = number % 10;
		 int tens = number % 100 - number % 10;
		 int hundreds = number % 1000 - number % 100;

		 if (hundreds != 0) {
			 add(this.numbers.get(hundreds / 100));
			 out += this.numbers.get(hundreds / 100) + " ";
			 add(this.numbers.get(100));
			 out += this.numbers.get(100) + " ";
		 }
		 if ((number % 100 > 10) && (number % 100 < 20)) {
			 add(this.numbers.get(number % 100));
			 out += this.numbers.get(number % 100) + " ";
		 } else {		 
		 if (tens != 0) {
			 out += this.numbers.get(tens) + " ";
			 add(this.numbers.get(tens));
		 }
		
		 if (units != 0) {
			 add(this.numbers.get(units));
			 out += this.numbers.get(units) + " ";
		 }}

	 
		 System.out.println(out);
		 
	}
	
	private void addAllNumbers() {
		for (int i = 1; i <= 1000; i++)
			addNumberToTotals(i);
	}
	
	
	private long countTotalChars() {
		return totals.entrySet().stream().mapToInt(z -> z.getValue() * z.getKey().length()).sum() + countOfAnds * "and".length();
	}
	
	@Override
	public String getResult() {
//		addNumberToTotals(115);
		addAllNumbers();
		return String.format("%d", countTotalChars());
	}

}
