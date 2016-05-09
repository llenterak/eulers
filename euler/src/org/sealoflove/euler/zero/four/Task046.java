package org.sealoflove.euler.zero.four;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.zero.zero.Task003;

public class Task046 implements Task {

	
	private int limit = 1000000;
	private Set<Integer> primes = new HashSet<>(Task003.getPrimeNumbers(limit));
	
	private long findSmallestDefiantNumber(int limit) {
		
		for (int i = 9; i < limit; i += 2) {
			if (primes.contains(i))
				continue; //only composites are evaluated
//			boolean[] marks = new boolean[i / 2];
			boolean found = false;
			long sqrlimit = new Double(Math.sqrt(i)).intValue();
			for (int a = 1; a < sqrlimit && !found; a++) {
				if (primes.contains(i - 2*a*a))
					found = true;
			}
			if (!found)
				return i;
		}
		return -1;
	}
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return String.format("%d", findSmallestDefiantNumber(limit));
	}

}
