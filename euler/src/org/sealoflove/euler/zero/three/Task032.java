package org.sealoflove.euler.zero.three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sealoflove.euler.Task;

public class Task032 implements Task {

	
	//list all four-digit and five-digit numbers
	//find divisors for each of them
	//for each divisor, check if its digits are distinct
	//and if number / divisor == something with distinct digits

	
	static Map<Integer, Boolean> distincts = new HashMap<>();
	
	
	private boolean isComplement(int i, int j, int res) {
		int[] counts = new int[10];
		while (i > 0) {
			if (i % 10 == 0)
				return false;
			counts[i % 10]++;
			i = i / 10;
		}
		while (j > 0) {
			if (j % 10 == 0)
				return false;
			counts[j % 10]++;
			j = j / 10;
		}
		while (res > 0) {
			if (res % 10 == 0)
				return false;
			counts[res % 10]++;
			res = res / 10;
		}
		
		for (int k = 1; k < 10; k++) {
			if (counts[k] > 1 || counts[k] == 0)
				return false;
		}
		return true;
	}
	
	
	private static boolean hasDistinct(int n) {
		if (distincts.containsKey(n))
			return distincts.get(n);
		int[] counts = new int[10];
		while (n > 0) {
			counts[n % 10]++;
			n = n / 10;
		}
		for (int i = 0; i < 10; i++)
			if (counts[i] > 1) {
				distincts.put(n, false);
				return false;
			}
		distincts.put(n, true);
		return true;
	}
	
	private Integer getPandigitalSum() {
		Set<Integer> marked = new HashSet<>();
//		Long sum = 0l;
		for (int i = 1000; i < 99999; i++) {
			for (int j = 2; j < Math.floor(Math.sqrt(i)); j++) {
				if (!hasDistinct(i) || !hasDistinct(j))
					continue;
				if (i % j == 0) {
					if (hasDistinct(i / j) && isComplement(i,j, i / j)) {
						marked.add(i);
					}
				}
			}
		}
		System.out.println(marked);
		return marked.stream().mapToInt(z -> z).sum();
	}
	
	
	@Override
	public String getResult() {
		return String.format("%d", getPandigitalSum());
	}

}
