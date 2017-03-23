package org.sealoflove.zero.three;

import java.util.HashSet;
import java.util.Set;

import org.sealoflove.Task;
import org.sealoflove.zero.zero.Task003;

public class Task035 implements Task {

	
	int limit = 1000000;
	Set<Integer> primes = new HashSet<Integer>(Task003.getPrimeNumbers(limit));
	
	//precomputed array with powers of 10, up to 10^7
	int[] powers = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
	
	
	private int rotate(Integer n) {
		int length = n.toString().length();
		return n/10 + n%10 * powers[length - 1];
	}
	
	private int countCircularPrimes(int limit) {
		Set<Integer> circularPrimes = new HashSet<>();
		int count = 0;
		for (Integer prime : primes) {
			if (prime == 1)
				continue;
			int length = prime.toString().length();
			boolean isCircular = true;
			Set<Integer> candidates = new HashSet<>();
			for (int i = 0; i < length; i++) {
				if (primes.contains(rotate(prime))) {
					candidates.add(rotate(prime));
					prime = rotate(prime);
				}
				else {
					isCircular = false;
					break;
				}
			}
			if (isCircular) {
				circularPrimes.addAll(candidates);
				count++;
				System.out.println(candidates);
			}
			


//			if ()
		}
		return count;
	}
	
	@Override
	public String getResult() {
		return String.format("%d", countCircularPrimes(limit));
	}

}
