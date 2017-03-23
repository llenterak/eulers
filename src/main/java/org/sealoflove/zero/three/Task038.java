package org.sealoflove.zero.three;

import org.sealoflove.Task;

public class Task038 implements Task {

	
	private static boolean hasNoRepeatingChars(String s) {
		for (char i = '1'; i <= '9' && s.length() > 0; i++) {
			int initL = s.length();
			s = s.replaceAll("" + i, "");
			int afterL = s.length();
			if (initL - afterL > 1)
				return false;
		}
		return true;
	}
	
	
	private boolean isPandigital(String s) {
		for (char i = '1'; i <= '9' && s.length() > 0; i++) {
			int initL = s.length();
			s = s.replaceAll("" + i, "");
			int afterL = s.length();
			if (initL - afterL != 1)
				return false;
		}
		if (s.length() > 0)
			return false;
		return true;
	}
	
	private Long findLargestPandigital(int limit) {
		Long max = 0l;
		for (int i = 1; i < limit; i++) {
			if (i == 192)
				System.out.println("");
			String s = "";
			int j = 1;
			while (s.length() < 9 ) {
				s = s + (i * j);
				j++;
				if (!hasNoRepeatingChars(s))
					break;
			}
			if (Long.parseLong(s) > max && isPandigital(s)) {
				max = Long.parseLong(s);
				System.out.println(i);
			}			
			
		}
		return max;
	}
	
	@Override
	public String getResult() {
		return String.format("%d", findLargestPandigital(1000000));
	}

}
