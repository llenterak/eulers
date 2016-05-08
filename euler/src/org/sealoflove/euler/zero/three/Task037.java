package org.sealoflove.euler.zero.three;

import java.util.HashSet;
import java.util.Set;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.zero.zero.Task003;

public class Task037 implements Task {

	
	private int limit = 1000000;
	private Set<Integer> primes = new HashSet<Integer>(Task003.getPrimeNumbers(limit));
	
	//remove leftmost digit
	private Integer truncateLeft(Integer n) {
		if (n < 10)
			return null;
		return Integer.parseInt(n.toString().substring(1));
	}
	
	//remove rightmost digit
	private Integer truncateRight(Integer n) {
		if (n < 10)
			return null;
		return n / 10;
	}
		
	
	int[] powers = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
	

	boolean isTrunc(Integer n, java.util.function.Function<Integer, Integer> function) {
		//check rightmost and leftmost digits for primeness
		if ((!primes.contains(n.toString().charAt(0) - '0')) || 
				(!primes.contains(n.toString().charAt(n.toString().length() - 1) - '0')))
			return false;
		
		while (n != null) {
			if (!primes.contains(n)) {
				return false;
			}
			n = function.apply(n);

		}
		return true;
	}
	
	
	private long findSumOfTruncatablePrimes() {
		long sum = 0l;
		for (Integer prime : primes) {
			if(isTrunc(prime, z -> truncateLeft(z)) && isTrunc(prime, z -> truncateRight(z)) && prime > 10){
				sum += prime;
			}
		}
		return sum;
	}
	
	
	@Override
	public String getResult() {
		
		return String.format("%d", findSumOfTruncatablePrimes());
	}

}
