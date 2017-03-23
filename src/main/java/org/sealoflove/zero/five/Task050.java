package org.sealoflove.zero.five;

import java.util.List;

import org.sealoflove.Task;
import org.sealoflove.zero.zero.Task003;

public class Task050 implements Task {

	
	int limit = 1000000;
	
	List<Integer> primes = Task003.getPrimeNumbers(limit);
	

	//we know that 21 terms make up 953
	//just concat 21 terms and see if we can add up for more
	
	
	private int findCutoff() {
		int s = 0;
		if (primes.size() < 22)
			return primes.get(primes.size() - 1);
		int largestPrime = primes.get(primes.size() - 1);
		for (int i = primes.size() - 1; i > primes.size() - 22; i--) {
			s += primes.get(i);
		}
		//find the cutoff: the largest number from which 21 consecutive terms are smaller than largesPrime
		for (int i = primes.size() - 23; i >= 0; i--) {
			if (s < primes.get(primes.size() - 1))
				return i;
			s -= primes.get(i + 21);
			s += primes.get(i);
		}
		return 0;
	}
	
	private int findLongestSum() {
		
		int maxPrime = 0;
		int cutoff = findCutoff(); 
		int maxLength = 0;

		for (int i = 0; i < cutoff; i++) {
			
			int s = 0;
			for (int j = 0; j < 22; j++) {
				s += primes.get(i + j);
			}
			int pos = 21;
			while (s < limit ) {
				s += primes.get(i + pos);
				pos++;
				if (primes.contains(s)) {
					if (pos > maxLength){
						maxLength = pos;
						maxPrime = s;
					}
				}
			}
		}
		System.out.println("Maxlength: " + maxLength);
		return maxPrime;
	}
	
	
	@Override
	public String getResult() {
		
		return String.format("%d", findLongestSum());
	}

}
