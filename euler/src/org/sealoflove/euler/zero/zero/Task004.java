package org.sealoflove.euler.zero.zero;

import org.sealoflove.euler.Task;

public class Task004 implements Task {

	//works for 3-digit numbers only
	private static int reverse(int n) {
		return n / 100 + (n % 10) * 100 + ((n / 10) % 10) * 10; 
	}
	
	boolean checkDividers(int number) {
		for (int i = 999; i > 100; i--) {
			int res = number / i;
			if (number % i == 0) {
				if (res < 1000 && res > 99) {
					System.out.println(String.format("%d*%d=%d", i, res, number));
					return true;
				}
					
			}
		}
		return false;
			
	}
	
	private Integer checkPalindromes() {
		for (int i = 999; i  > 100; i--) {
			int palindrome = i * 1000 + reverse(i);
			if (checkDividers(palindrome))
				return palindrome;
		}
		return null;
	}
	
	
	@Override
	public String getResult() {
		return String.format("%d", checkPalindromes());
	}

}
