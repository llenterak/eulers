package org.sealoflove.zero.four;

import java.util.List;

import org.sealoflove.Task;
import org.sealoflove.zero.zero.Task003;

public class Task047 implements Task {

	List<Integer> primes = Task003.getPrimeNumbers(1000000);
	
	private int countDistinctFactors(int n) {
		int count = 0;
		int i = 0;
//		int limit = new Double(Math.sqrt(n)).intValue();
		int limit = n / 2;
		while (n > 1 && primes.get(i) <= limit) {
			if (n % primes.get(i) == 0) {
				count++;
				n = n / primes.get(i);
			}
			i++;
		}
		return count;
	}
	
	
	private int findFirstFourCuriousNumbers(int reqConsecNumbers, int reqFactorsNumber) {
		int consecutiveNumbers = 0;
		int first = 0;
//		for (int i = 2*3*5*7; consecutiveNumbers < 4; i++) {
			for (int i = 2; consecutiveNumbers < reqConsecNumbers; i++) {
			if (countDistinctFactors(i) == reqFactorsNumber){
				if (consecutiveNumbers == 0)
					first = i;
				consecutiveNumbers++;
			} else {
				consecutiveNumbers = 0;
				first = 0;
			}
		}
		return first;
	}
	
	
	@Override
	public String getResult() {

//		System.out.println(countDistinctFactors(645));
		return String.format("%d", findFirstFourCuriousNumbers(4, 4));
	}

}
