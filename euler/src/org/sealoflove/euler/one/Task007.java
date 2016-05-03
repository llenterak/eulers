package org.sealoflove.euler.one;

import java.util.List;

import org.sealoflove.euler.Task;

public class Task007 implements Task {

	
	public Integer getNthPrime(int n, int seed) {
		List<Integer> primes = Task003.getPrimeNumbers(seed);
		if (primes.size() < n)
			return getNthPrime(n, seed * 2);
		return primes.get(n);
			
		
	}
	
	@Override
	public String getResult() {
		return String.format("%d", getNthPrime(10001, 10000));
//		return String.join(" ", getPrimeNumbers(30).stream().filter(z -> z != 0).map(Object::toString).collect(Collectors.toList()));

//		return null;
	}

}
