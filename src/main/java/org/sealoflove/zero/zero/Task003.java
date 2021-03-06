package org.sealoflove.zero.zero;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.sealoflove.Task;

public class Task003 implements Task {

	
	

	
	
	public static List<Integer> getPrimeNumbers(Integer limit) {
		return getPrimeNumbers(limit, null);
	}
	
	public static List<Integer> getPrimeNumbers(Integer limit, Integer lowerLimit) {
		Integer[] allNumbers = new Integer[limit];
		for (int i = 0; i < limit; i++) {
			allNumbers[i] = i;
		}
		for (Integer i = 2; i < limit / 2; i++) {
			if (allNumbers[i] != 0)
				for (Integer j = 2; i * j < limit; j++) {
					allNumbers[i * j] = 0;
				}
		}
		if (lowerLimit != null) {
			return Arrays.asList(allNumbers).stream().filter(z -> z != 0 && z != 1 && z > lowerLimit).collect(Collectors.toList());
		}
		return Arrays.asList(allNumbers).stream().filter(z -> z != 0 && z != 1).collect(Collectors.toList());
	}
	
	private Integer getLargestPrimeDivider(Long limit) {
		List<Integer> primes = getPrimeNumbers(new Double(Math.floor(Math.sqrt(limit))).intValue());
		for (int i = primes.size() - 1; i > 0; i--)
			if (limit % primes.get(i) == 0)
				return primes.get(i);
		return null;
	}
	
	
	@Override
	public String getResult() {
		return String.format("%d", getLargestPrimeDivider(600851475143l));
//		return "";
//		return String.join(" ", getPrimeNumbers(30).stream().filter(z -> z != 0).map(Object::toString).collect(Collectors.toList()));
	}

}
