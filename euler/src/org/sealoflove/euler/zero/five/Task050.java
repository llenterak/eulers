package org.sealoflove.euler.zero.five;

import java.util.List;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.zero.zero.Task003;

public class Task050 implements Task {

	
	int limit = 100;
	
	List<Integer> primes = Task003.getPrimeNumbers(limit);
	
	
	private int findLongestChain() {
		int max = 0;
		for (int i = primes.size(); i > 0; i--) {
			
		}
		return max;
	}
	
	@Override
	public String getResult() {
		
		return null;
	}

}
