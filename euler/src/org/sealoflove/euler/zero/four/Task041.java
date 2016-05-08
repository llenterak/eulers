package org.sealoflove.euler.zero.four;

import java.util.HashSet;
import java.util.List;
import java.util.OptionalLong;
import java.util.Set;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.zero.zero.Task003;

public class Task041 implements Task {
	
	
	List<Integer> primes = Task003.getPrimeNumbers(new Double(Math.sqrt(87654321)).intValue());
	
	
	//a number is prime if it's not divisible by other primes smaller than its square root
	//on the first sight, can't use task003's Sieve of Erathosthene, numbers are too large
	//on a second attempt, though, we need primes up to 
	private boolean isPrime(long n) {
		long limit = new Double(Math.sqrt(n)).intValue() + 1;
		int i = 2;
		while (primes.get(i) < limit) {
//		while (i < limit) {
			if (n % i == 0)
				return false;
			i++;
		}
		return true;
	}
	
	
	
	
	/*
	 * Explanation here:
	 * 1) 123456789 will be always divisible by 3 and 9, so skipping it:
	 * 2) starting from 12345678

	 */
	
	Set<Long> filteredPrimes = new HashSet<>();
	
//	private long concat(List<Integer> list) {
//		long res = 0l;
//		for (int i = list.size() - 1; i >= 0; i-- ) {
//			res *= 10;
//			res += i;
//		}
//		return res;
//	}
	
	private void recursiveGenerator(String used, String unused) {
		if (unused.length() == 0) {
//			System.out.println(used);
//			long res = concat(used);
			long res = Long.parseLong(used);
			if (isPrime(res)) {
				filteredPrimes.add(res);
			}
		} else {
			unused.chars().map(z -> z - '0').forEach(z -> recursiveGenerator(used + z, unused.replaceAll("" + z, "")));
		}
	}
	
	
	
	@Override
	public String getResult() {
		recursiveGenerator("", "1234567");
		// TODO Auto-generated method stub
		OptionalLong d = filteredPrimes.stream().mapToLong(z -> z).max();
		return String.format("%d", d.isPresent() ? d.getAsLong() : null);
	}

}
