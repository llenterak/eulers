package org.sealoflove.zero.four;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sealoflove.Task;
import org.sealoflove.zero.zero.Task003;

public class Task049 implements Task {

	
	
	List<Integer> primes = Task003.getPrimeNumbers(10000, 1000);
	Set<Integer> primeSet = new HashSet<>(primes);
	
	Set<Integer> banned = new HashSet<>(Arrays.asList(1487, 4817, 8147));
	
	private boolean containSameDigits(Integer a, Integer b) {
		int[] countsA = new int[10];
		int[] countsB = new int[10];
		while (a > 0) {
			countsA[a % 10]++;
			a = a / 10;
		}
		while (b > 0) {
			countsB[b % 10]++;
			b = b / 10;
		}
		for (int i = 0; i < countsA.length; i++) 
			if (countsA[i] != countsB[i])
				return false;
		return true;
	}
	
	private String findCuriousPrimes() {
		
		String res = "";
		for (int i = 0; i < primes.size(); i++) {
			if (banned.contains(primes.get(i)))
				continue;
			for (int j = i + 1; j < primes.size() - 1; j++) {
				if (containSameDigits(primes.get(i), primes.get(j))) {
					Integer t3 = primes.get(j) - primes.get(i) + primes.get(j);
					if (primeSet.contains(t3) && containSameDigits(primes.get(i), t3))
						return primes.get(i).toString() + primes.get(j).toString() + t3.toString();  
				}
			}
		}
		return "";
	}
	
	
	@Override
	public String getResult() {
		return String.format("%s", findCuriousPrimes());
//		return null;
	}

}
