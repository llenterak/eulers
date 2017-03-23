package org.sealoflove;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sealoflove.zero.zero.Task003;



public class ExplodedNumber implements Comparable<ExplodedNumber>{

	static List<Integer> primes = Task003.getPrimeNumbers(1000000);
	private static BigInteger power(Integer a, Integer b) {
		BigInteger base = BigInteger.ONE;
		for (int i = 0; i < b; i++) { 
			base = base.multiply(new BigInteger(a.toString()));
		}
		return base;
	}
	
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

