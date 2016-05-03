package org.sealoflove.euler.three;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.sealoflove.euler.Task;

public class Task026 implements Task {

	
	
	
	private String getLongestRecurrentStringBorked(String rec) {
		rec = rec.substring(2);
		int[] counts = new int[10];
		boolean[] marked = new boolean[10];
		for (int i = 0; i < 10; i++) {
			counts[i] = 0;
			marked[i] = false;
		}
		for (char c = '0'; c <= '9'; c++) {
			int pos = c - '0';
			int count = rec.length() - rec.replace("" + c, "").length();
			counts[pos] = count;
		}
//		Arrays.stream(counts).forEach(z -> System.out.println(z));
		int max = 0;
		for (int i = 0; i < 10; i++){
			if (counts[i] > max)
				max = counts[i];
		}
		System.out.print("[" + max +"]");
		String recurrence = "";
		for (char i = 0; i < 10; i++) {
			if (Math.abs(counts[i] - max) < 5) {
				marked[i] = true;
//				char w = (char)('0' + i);
//				recurrence += "" + w;
			}
		}
		
//		for ()
		
		return recurrence;
	}
	
	private String getLongestRecurrent(String input) {
		//i is the index for a beginning of a possibly recurring string
		for (int i = 0; i < input.length(); i++) {
			
		}
		return "";
	}
	
	
	private int getLongestRecurrentStrings(int limit, int scale) {
		int min = 999; 
//		int scale = 1000;
		for (int i = 2; i <= limit; i++) {
			BigDecimal val =  BigDecimal.ONE.divide(new BigDecimal(i), scale, RoundingMode.HALF_UP);
			
			
		}
		return 0;
	}
	
	
	@Override
	public String getResult() {
//		return getLongestRecurrentStrings(1000, 1000);
		return "";
//		return getLongestRecurrentString("123452342342342");
	}

}
