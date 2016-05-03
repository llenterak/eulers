package org.sealoflove.euler.two;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.one.Task003;

public class Task015 implements Task {
	//it's n!/((m1!)*(m2!))
	
	private Map<Integer, Integer> prod(Map<Integer, Integer> a, Map<Integer, Integer> b) {
		Map<Integer, Integer> res = new HashMap<>();
		
		for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
			if (b.get(entry.getKey()) != null) {
				res.put(entry.getKey(), entry.getValue() + b.get(entry.getKey()));
			} else 
				res.put(entry.getKey(), entry.getValue());
		}
		for (Map.Entry<Integer, Integer> entry : b.entrySet()) {
			if (a.get(entry.getKey()) == null) {
				res.put(entry.getKey(), entry.getValue());
			}
		}
		return res;
	}

	
	
	
	//just forget & ignore 1
	private Map<Integer, Integer> decompose(int n) {
		Map<Integer, Integer> res = new HashMap<>();
		
		for (int i = 0; i < primes.size(); i++) {
			if (primes.get(i) == 1)
				continue;
			int p = n;
			while (p % primes.get(i) == 0) {
				if (res.containsKey(primes.get(i))) {
					int c = res.get(primes.get(i));
					res.put(primes.get(i),  c + 1);
				}
				else 
					res.put(primes.get(i), 1);
				p = p / primes.get(i);
			}
		}
		return res;
	}
	
	private Map<Integer, Integer> autoReduce(Map<Integer, Integer> number) {
		Map<Integer, Integer> res = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : number.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++)
				res = prod(res, decompose(entry.getKey()));
		}
		return res;
	}
	
	
	
	
	private Map<Integer, Integer> factorial(int n) {
		Map<Integer, Integer> res = new HashMap<>();
		for (int i = 2; i <= n; i++) {
			res.put(i, 1);
		}
		return res;
	}
	public static BigDecimal result(Map<Integer, Integer> number) {
		BigDecimal res = new BigDecimal("1");
		for (Map.Entry<Integer, Integer> entry : number.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++)
				res = res.multiply(new BigDecimal(entry.getKey()));
		}
		return res;
	}
	
	
	List<Integer> primes;
	
	
	private Map<Integer, Integer> reduceFraction(Map<Integer, Integer> rawA, Map<Integer, Integer> rawB) {
		Map<Integer, Integer> reducedA = autoReduce(rawA);
		Map<Integer, Integer> reducedB = autoReduce(rawB);
		
		Map<Integer, Integer> res = new HashMap<>();
		
		for (Map.Entry<Integer, Integer> entry : reducedA.entrySet()) {
			int count = entry.getValue();
			if (reducedB.containsKey(entry.getKey()))
				count = entry.getValue() - reducedB.get(entry.getKey());
			if (count > 0)
				res.put(entry.getKey(), count);
			if (count < 0)
				throw new RuntimeException("Cannot be reduced!");
			reducedB.remove(entry.getKey());
		}
		if (!reducedB.isEmpty())
			throw new RuntimeException("Cannot be reduced!");
		return res;
	}
	
	private String calculateCombinations(int size) {
		primes = Task003.getPrimeNumbers(2 * size);
		return result(reduceFraction(factorial(2*size),autoReduce(prod(factorial(size), factorial(size))))).toString();
	}
	
	@Override
	public String getResult() {
		return String.format("%s", calculateCombinations(20));
	}

}
