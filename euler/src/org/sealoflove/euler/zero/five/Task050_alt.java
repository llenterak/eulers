package org.sealoflove.euler.zero.five;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.zero.zero.Task003;

public class Task050_alt implements Task {

	
	int limit = 1000000;
	
	List<Integer> primes = Task003.getPrimeNumbers(limit);
	Set<Integer> primesSet = new HashSet<>(primes);
		
	List<Integer> sums = getPartialSums();
	
	private List<Integer> getPartialSums() {
//		System.out.println(primes);
		List<Integer> res = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < primes.size(); i++) {
			res.add(sum);
			sum += primes.get(i);
		}
		return res;
	}
	
	private int findLongestSum() {
		int maxDistance = 0;
		int maxPrime = 0;
//		System.out.println(sums);
//		System.out.println(primes);
		for (int i = 0; i < sums.size(); i++) {
			
			for (int j = i + 1; j < sums.size(); j++) {
				//cursor sum = sums.get(i) - sums.get(j)
				int sum = sums.get(j) - sums.get(i);
				if (sum > limit)
					break;
//				System.out.println(sum);
				if (primesSet.contains(sum)) {
					if (maxDistance < j - i) {
						maxDistance = j-i;
						maxPrime = sum;
					}
				}
					
			}
		}
		System.out.println(maxDistance);
		return maxPrime;
	}
	
	
	
	@Override
	public String getResult() {
		
		return String.format("%d", findLongestSum());
	}

}
