package org.sealoflove.euler.one;

import org.sealoflove.euler.Task;

public class Task006 implements Task {

	
	private Long getSumOfSquares(Long n) {
		return n * (n+1) * (2*n + 1) / 6;
	}
	
	private Long getSquareOfSeq(Long n) {
		Long s = 0l;
		for (int i = 1; i <= n; i++) 
			s += i;
		return s * s;
	}
	
	@Override
	public String getResult() {
		return String.format("%d", getSquareOfSeq(100l) - getSumOfSquares(100l));
	}

}
