package org.sealoflove.zero.two;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sealoflove.Task;
import org.sealoflove.zero.zero.Task003;

public class Task029 implements Task {

	
	List<Integer> primes;
	
	private static BigInteger power(Integer a, Integer b) {
		BigInteger base = BigInteger.ONE;
		for (int i = 0; i < b; i++) { 
			base = base.multiply(new BigInteger(a.toString()));
		}
		return base;
	}
	
	class ExplodedNumber implements Comparable<ExplodedNumber>{
		private Map<Integer, Integer> factors = new HashMap<>();
		private BigInteger computed = null;
		private BigInteger direct = null;
		
		
		
		public ExplodedNumber(int n) {
			int i = primes.get(1);
			int k = 0;
			while (i <= n) {
				while (n % i == 0) {
					Integer count = factors.get(i);
					if (count == null) 
						factors.put(i, 1);
					else
						factors.put(i, count + 1);
					n = n / i;
				}
				k++;
//				if (k == 26) {
//					System.out.println("asdsd");
//				}
				i = primes.get(k);

			}
		}

		
		
		public BigInteger computeResult() {
			BigInteger base = BigInteger.ONE;
			for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
				for (int i = 0; i < entry.getValue(); i++) {
					base = base.multiply(new BigInteger(entry.getKey().toString()));
				}
			}
			return base;
		}
		
		public ExplodedNumber(int n, int power) {
			this(n);
			for (Map.Entry<Integer, Integer> entry : this.factors.entrySet()) {
				int count = entry.getValue() * power;
				factors.put(entry.getKey(), count);
			}
			computed = computeResult();
			direct = power(n, power);
			if (!computed.equals(direct))
				System.out.println(String.format("NOT WORKING: %d, %d", n, power));

		}		
		
		@Override
		public String toString() {
			StringBuilder bld = new StringBuilder();
			bld.append("[");
			for (Map.Entry<Integer, Integer> entry: this.factors.entrySet()) {
				bld.append("<");
				bld.append(entry.getKey());
				bld.append(":");
				bld.append(entry.getValue());
				bld.append(">");
			}
			bld.append("]");
			return bld.toString();
		};
		
		@Override
		public boolean equals(Object o) {
			return this.compareTo((ExplodedNumber)o) == 0;
		}

		@Override
		public int hashCode() {
			int  s = 0;
			for (Map.Entry<Integer, Integer> entry : this.factors.entrySet()) {
				s += entry.getValue();
			} 
			return s;
		};

		@Override
		public int compareTo(ExplodedNumber o) {
			for (Map.Entry<Integer, Integer> entry : this.factors.entrySet()) {
				Integer other = o.factors.get(entry.getKey());
				if ((other == null) || (!other.equals(entry.getValue())))
						return -1;
			}
			return 0;
		}
	}
	
	
	private boolean testSet() {
		Set<ExplodedNumber> exp = new HashSet<>(); 
		exp.add(new ExplodedNumber(2));
		exp.add(new ExplodedNumber(2));
		exp.add(new ExplodedNumber(2));
		exp.add(new ExplodedNumber(3));
		exp.add(new ExplodedNumber(6));
		System.out.println(exp.size());
		List<ExplodedNumber> list = new ArrayList<>(exp);
		return exp.size() == 3;
		
	}
	
	List<ExplodedNumber> premadeExploded = new ArrayList<>();
	private void populatePremadeExplodedList(int limit) {
		for (int i = 0; i <= limit; i++) {
			premadeExploded.add(new ExplodedNumber(i));
		}
	}
	
	
	/*
	 * three steps:
	 * 1) decompose into prime factors each number
	 * 2) iterate a[2..100{b2..100}] and place each result in a set
	 * 3) count elements of the set
	 * 
	 * footnote: we don't really care for the computed result of each number
	 */
	
	Set<ExplodedNumber> totals = new HashSet<ExplodedNumber>();
	Set<BigInteger> bigints = new HashSet<BigInteger>();
	private int countDistinctElements(int limit) {
		for (int a = 2; a <= limit; a++) {
			for (int b = 2; b <= limit; b++) {
				totals.add(new ExplodedNumber(a, b));
				bigints.add(power(a, b));
//				System.out.println(String.format("%d to the power of %d", a, b));
			}
		}
//		System.out.println(totals);
		return bigints.size();
	}
	
	
	@Override
	public String getResult() {
		primes = Task003.getPrimeNumbers(200);
//		populatePremadeExplodedList(100);
//		System.out.println("Premade size:", );
		System.out.println(testSet());
		return String.format("%d", countDistinctElements(100));
	}

}

