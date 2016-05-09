package org.sealoflove.euler.zero.four;

import org.sealoflove.euler.Task;

public class Task048 implements Task {

	
	
	long findModuloSumOfPowers(long limit, long mod) {
		long res = 0; 
		for (int i = 1; i <= limit; i++) {
			long p = 1;
			for (int j = 0; j < i; j++) {
				p *= i % mod;
				p = p % mod;
			}
			res += p;
			res = res % mod;
		}
		return res;
	}
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
//		return String.format("%d", Long.MAX_VALUE);
		return String.format("%d", findModuloSumOfPowers(1000, 10000000000l));
	}

}