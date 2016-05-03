package org.sealoflove.euler.two;

import java.math.BigDecimal;

import org.sealoflove.euler.Task;

public class Task020 implements Task {

	
	private static String calculateSum(int n) {
		return Task016.sumDigits(factorial(n).toString(), 1);
	}
	
	
	private static BigDecimal factorial(int n) {
		BigDecimal res = new BigDecimal("1");
		for (int i = 2; i <= n; i++) {
			res = res.multiply(new BigDecimal(i));
		}
		return res;
	}
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return calculateSum(100);
	}

}
