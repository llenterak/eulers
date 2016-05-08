package org.sealoflove.euler.zero.three;


import org.sealoflove.euler.Task;

public class Task034 implements Task {

	
	
	
	private int[] factorials = genDigitFactorials();
	
	private static int[] genDigitFactorials() {
		int[] res = new int[10];
		res[0] = 1;
		int f = 1;
		for (int i = 1; i < 10; i++) {
			f *= i;
			res[i] = f; 
		}
		return res;
	}
	
	private int sumDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += factorials[n % 10];
			n = n / 10;
		}
		return sum;
	}
	
	
	private long getDigitFactorials(int limit) {
		long res = 0l;
		for (int i = 3; i < limit; i++) {
			if (sumDigits(i) == i)
				res += i;
		}
		return res;
	}
	
	@Override
	public String getResult() {
		
		return String.format("%d", getDigitFactorials(1000000));
	}

}
