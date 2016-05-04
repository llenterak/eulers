package org.sealoflove.euler.zero.two;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Predicate;

import org.sealoflove.euler.Task;

public class Task025 implements Task {

	
	
	
	
	private Long incFibonaccisUntilCondition(Predicate<String> condition) {
		BigDecimal[] t = new BigDecimal[3];
		t[0] = new BigDecimal("1");
		t[1] = new BigDecimal("1");
		t[2] = t[0].add(t[1]);
		
		long i = 3l;
		while (!condition.test(t[2].toString())) {

			t[0] = t[1].add(t[2]);
			Arrays.sort(t);
			i++;
		}
		return i;
	}
	
	
	
	@Override
	public String getResult() {
		return String.format("%d", incFibonaccisUntilCondition(z -> z.length() == 1000));
	}

}
