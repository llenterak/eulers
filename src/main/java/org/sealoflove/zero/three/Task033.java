package org.sealoflove.zero.three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sealoflove.Task;

public class Task033 implements Task {

	
	
	Map<Integer, Set<Integer>> mulToDiv = new HashMap<>();
	int limit;
	
	private void populateMaps(int limit) {
		for (int i = 1; i < limit; i++) {
			for (int j = i; j < limit; j++) {
				if (i * j < limit) {
					if (!mulToDiv.containsKey(i * j)) {
						mulToDiv.put(i * j, new HashSet<>());
					}
					mulToDiv.get(i * j).add(i);
					mulToDiv.get(i * j).add(j);
				}
			}
		}
	}
	
	int findLargestCommonDenominator(int a, int b) {
		Set<Integer> denominators = new HashSet<>();
		
		if (a > 100 || b > 100) {
			
			//do it the stupid, old-fashioned way
			for (int i = 1; i <= a; i++) {
				if ((a % i == 0) && (b % i == 0))
					denominators.add(i);
			}
		} else { 
			for (Integer den : mulToDiv.get(a)) {
				if (mulToDiv.get(b).contains(den)) {
					denominators.add(den);
				}
			}
		}
		int max = 0;
		for (Integer den : denominators) {
			if (den > max)
				max = den;
		}
		return max;
	}
	
	class Fraction implements Comparable<Fraction>{
		final Integer num;
		final Integer den;
		
		Fraction prod(Fraction o) {
			return new Fraction(num * o.num, den * o.den);
		}
		
		Fraction simplified() {
			int commonDen = findLargestCommonDenominator(num, den);
			return new Fraction(num / commonDen, den / commonDen);
		}
		
		public Fraction(String input) {
			this.num = Integer.parseInt(input.substring(0, input.indexOf('/')));
			this.den = Integer.parseInt(input.substring(input.indexOf('/') + 1));
		}
		
		//stupid simplify: 14/48 would become 1/8
		Fraction stupid() {
			int[] numbers = new int[10];
			numbers[num % 10]++;
			numbers[num / 10]++;
			numbers[den % 10]++;
			numbers[den / 10]++;
			
			for (char i = '0'; i <= '9'; i++) {
				if (numbers[i - '0'] == 2) {
					String newfr = this.toString().replaceAll("" + i, "");
					return new Fraction(newfr);
				}
			}
			return this;
		}
		
		public Fraction(int num, int den) {
			if (den == 0)
				throw new ArithmeticException("division by 0");
			this.num = num;
			this.den = den;
		}
		@Override
		public int compareTo(Fraction o) {
			return num * o.den - o.num * den;
		}
		
		@Override
		public boolean equals(Object o) {
			return this.compareTo((Fraction)o) == 0;
		}
		
		@Override
		public String toString() {
			return String.format("%d/%d", num, den);
		}
	}
	
	private int generateCombos() {
		Fraction prod = new Fraction(1, 1);
		for (int i = 10; i < 99; i++) {
			for (int j = i + 1; j <= 99; j++) {
				Fraction fr = new Fraction(i, j);
				try {
				if (fr.stupid().equals(fr) && fr.stupid().toString().length() < fr.toString().length()
						&& (fr.den * fr.num % 100 != 0)) {
					System.out.println(fr + "|" + fr.stupid());
					prod = prod.prod(fr);
				}
				} catch (NumberFormatException exc) {
					//for cases like 11/22 -> too much hassle to exclude those cases, just catch the exc
				}
			}
		}
		System.out.println(prod);
		return prod.simplified().den;
	}
	
	@Override
	public String getResult() {
		this.limit = 100;
		populateMaps(limit);
		return String.format("%d", generateCombos());
	}
}