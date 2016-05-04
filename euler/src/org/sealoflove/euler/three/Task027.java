package org.sealoflove.euler.three;

import java.util.List;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.one.Task003;

public class Task027 implements Task {

	
	/*Considering quadratics of the form:
	
	n² + an + b, where |a| < 1000 and |b| < 1000
	
	where |n| is the modulus/absolute value of n
	e.g. |11| = 11 and |−4| = 4
	Find the product of the coefficients, a and b, 
	for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
	*/
	
	List<Integer> primes = Task003.getPrimeNumbers(2000000);
	
	Integer res(Integer a, Integer b, Integer n) {
		return n * n + a*n + b;
	}
	
	int calculateProd(int limit) {
		
		int maxSeq = 0;
		int maxProd = 0;
		for (Integer a = -limit; a < limit; a++) {
			for (Integer b = -limit; b < limit; b++) {
//				System.out.print(String.format("%+3d, %+3d :", a, b));
				boolean isPrime = true;
				Integer n = 0;
				int seq = 0;
				while (isPrime) {
					Integer res = res(a, b, n);
					n++;
//					System.out.print(" " + res);
					isPrime = primes.contains(res);
					seq++;
				}
				if (seq > maxSeq) {
					maxSeq = seq;
					maxProd = a * b;
				}
//				System.out.println();

				
			}
		}
		return maxProd;
	}
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return String.format("%d", calculateProd(100));
	}

}
