package org.sealoflove.zero.three;

import org.sealoflove.Task;

public class Task036 implements Task {

	boolean isPalindrome(String p) {
		for (int i = 0; i < p.length() / 2; i++) {
			if (p.charAt(i) != p.charAt(p.length() - i - 1))
				return false;
		}
		return true;
	}
	
	private long findSumOfDoublePalindromes(int limit) {
		long s = 0;
		for (Integer i = 1; i < limit; i++) {
			if (isPalindrome(i.toString()) && isPalindrome(Integer.toBinaryString(i)))
				s += i;
		}
		return s;
	}
	
	@Override
	public String getResult() {
		return String.format("%d", findSumOfDoublePalindromes(1000000));
	}

}
