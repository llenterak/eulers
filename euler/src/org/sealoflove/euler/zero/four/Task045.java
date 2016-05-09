package org.sealoflove.euler.zero.four;

import org.sealoflove.euler.Task;

public class Task045 implements Task {

	
	private boolean isTriangle(long n) {
		long val = new Double(Math.sqrt(8*n + 1)).longValue();
		if ((val * val != 8*n + 1) )
			return false;
		return true;
	}
	
	private boolean isPentagonal(long n) {
		long val = new Double(Math.sqrt(24*n + 1)).longValue();
		if ((val * val != 24*n + 1) || (val % 6 != 5))
			return false;
		return true;
	}
	
	
	private static long p(long n) {	return n * (3 * n - 1) / 2;	}
	private static long h(long n) {	return 2*n * (2 * n - 1) / 2;	}
	private static long t(long n) {	return n * (n + 1) / 2;	}
	
	private long findTriplePointNumber() {
		long i = 1;
		while(true) {
			long x = h(i);
			if (isPentagonal(x) && isTriangle(x) && x > 40755)
				return x;
			i++;
		}
	}
	
	@Override
	public String getResult() {

		return String.format("%d", findTriplePointNumber());
	}

}
