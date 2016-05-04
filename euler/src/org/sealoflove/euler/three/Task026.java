package org.sealoflove.euler.three;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	private static int countMatches(String s, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(s);
		int count = 0;
		while (matcher.find())
			count++;
		return count;
	}
	
	private String getLongestRecurrent(String input) {
		//i is the index for a beginning of a possibly recurring string
		String maxSeq = "";
		int maxCount = 0;
		
		for (int i = 0; i < input.length() - 1; i++) {
			String subseq = input.substring(i);
			String currentSeq = "" + input.charAt(i);
			int count;
			int countDoubled;
			int k = 1;
			do { 
				currentSeq += input.charAt(i + k);
				
				k++;
				count = countMatches(subseq, currentSeq);
				countDoubled = countMatches(subseq, currentSeq + currentSeq);
			} while ((count > 0) && (countDoubled == 0) && (i + k < input.length() - 1));
			if (count == 0)
				continue;
			if (maxCount < count) {
				maxCount = count;
				maxSeq = currentSeq;
				System.out.println(maxSeq);
				return maxSeq;
			}

			
		}
		
		return maxSeq;
	}
	
	
	private int getLongestRecurrentStrings(int limit, int scale) {
		int max = 0; 
		int maxi = -1;
//		int scale = 1000;
		
		for (int i = 2; i <= limit; i++) {
//			if (i == 7)
//				System.out.println("");
			BigDecimal val =  BigDecimal.ONE.divide(new BigDecimal(i), scale, RoundingMode.HALF_UP);
			System.out.print("" + i + ":" + val.toString() + ": ");
			String candidate = getLongestRecurrent(val.toString().substring(2));
			if (candidate.length() > max){
				max = candidate.length();
				maxi = i;
			}
		}
		System.out.println(max);
		return maxi;
	}
	
	
	@Override
	public String getResult() {
		return String.format("%d", getLongestRecurrentStrings(1000, 500));
//		return "";
//		return getLongestRecurrentString("123452342342342");
	}

}
