package org.sealoflove.zero.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sealoflove.Task;

public class Task043 implements Task {

	
	Map<Integer, List<Integer>> tokenMap;
	
	int[] base = {2, 3, 5, 7, 11, 13, 17};	
	
	private static boolean hasNoRepeatingChars(int i) {
		return hasNoRepeatingChars(new Integer(i).toString());
	}
	
	private static boolean hasNoRepeatingChars(String s) {
		for (char i = '0'; i <= '9' && s.length() > 0; i++) {
			int initL = s.length();
			s = s.replaceAll("" + i, "");
			int afterL = s.length();
			if (initL - afterL > 1)
				return false;
		}
		return true;
	}

	private Map<Integer, List<Integer>> populateMap() {
		Map<Integer, List<Integer>> tokens= new HashMap<>();
		for (Integer i = 0; i < base.length; i++) {
			tokens.put(base[i], new ArrayList<>());
			for (int j = 1; base[i] * j < 999; j++) {
				if (base[i] * j > 100 && hasNoRepeatingChars(base[i]*j)) {
					tokens.get(base[i]).add(base[i] * j);
				}
			}
		}
		return tokens;
	}
	
	
	private boolean isCuriousNumber(String s) {
		if (!hasNoRepeatingChars(s))
			return false;
		for (int i = 0; i < base.length; i++) {
			Integer substr = Integer.parseInt(s.substring(i, i+3));
			if (substr % base[i] != 0)
				return false;
		}
		return true;
	}
	
	private String enhance(String s) {
		for (char c = '1'; c <= '9'; c++) {
			if (!s.contains("" + c))
				return "" + c + s;
		}
		return null;
	}
	
	
	private void recursiveConcat(String used, int i) {
		if (!hasNoRepeatingChars(used))
			return;
		if (used.length() == 9) {
			if (isCuriousNumber(used)) {
				String enh = enhance(used);
				if (enh != null)
					result.add(Long.parseLong(enh));
			}
		}
		else {
			List<Integer> src = tokenMap.get(base[i]);
			for (Integer p : src) {
				recursiveConcat(used + p, i + 3);
			}
		}
	}
	
	List<Long> result = new ArrayList<>();
	
	private Long countCuriousNumbers() {
		int count = 0;
		tokenMap = populateMap();
		
		recursiveConcat("", 0);
		return result.stream().mapToLong(z -> z).sum();
	}
	
	@Override
	public String getResult() {
		return String.format("%d", countCuriousNumbers());
	}

}
