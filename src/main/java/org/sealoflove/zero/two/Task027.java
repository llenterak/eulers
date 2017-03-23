package org.sealoflove.zero.two;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import org.sealoflove.Task;
import org.sealoflove.zero.zero.Task003;

public class Task027 implements Task {

	
	/*Considering quadratics of the form:
	
	n² + an + b, where |a| < 1000 and |b| < 1000
	
	where |n| is the modulus/absolute value of n
	e.g. |11| = 11 and |−4| = 4
	Find the product of the coefficients, a and b, 
	for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
	*/
	
	int limit = 1000;
	
	List<Integer> primes = Task003.getPrimeNumbers(1000000);
	OptionalInt maxPrime = primes.stream().mapToInt(z -> z).max();
	List<Integer> primesB = populateB(Task003.getPrimeNumbers(1000));

	private List<Integer> valsA = populateA(limit);
	
	private static List<Integer> populateA(int limit) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < limit / 2 - 1; i++) {
			res.add(i * 2 + 1);
			res.add(-(i * 2 + 1));
		}
		return res;
	}
	
	private static List<Integer> populateB(List<Integer> genPrimes){ 
		List<Integer> res = new ArrayList<>();
		for (Integer b : genPrimes){
			res.add(b);
//			res.add(-b);
		}
		return res;
	}
	
	
	Integer res(Integer a, Integer b, Integer n) {
		return n*(a+n) + b;
	}
	
	int calculateProd(int limit) {
		
		int maxSeq = 0;
		int maxProd = 0;
		for (Integer a : valsA) {
			for (Integer b : primesB) {
				System.out.print(String.format("%+3d, %+3d; maxseq: %4d:", a, b, maxSeq));
				Integer res = res(a, b, maxSeq);
				if (res > maxPrime.getAsInt())
					throw new RuntimeException();
				boolean isPrime = primes.contains(res);
				Integer n = 0;
//				int seq = 0;
				while (isPrime) {
					res = res(a, b, n);
					if (res > maxPrime.getAsInt())
						throw new RuntimeException();
					n++;
					System.out.print(" " + res);
					isPrime = primes.contains(res);
//					seq++;
				}
				n--; //last number will be borked (since we abandoned on it)
				if (n > maxSeq) {
					maxSeq = n;
					maxProd = a * b;
				}
				System.out.println();

				
			}
		}
		return maxProd;
	}
	
	@Override
	public String getResult() {
//		this.limit = 100;
		// TODO Auto-generated method stub
		return String.format("%d", calculateProd(limit));
	}

}
