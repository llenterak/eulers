package org.sealoflove.euler.one;

import org.sealoflove.euler.Task;

public class Task001 implements Task{

	
	private Integer sumOfMultiplesOf(int n, Integer other, int limit) {
		int s = 0;
		int m = n;
		for (; m < limit; m+= n) {
			if (other == null || m % other != 0) {
//				System.out.println(m);
				s += m;
			}
		}
		return s;
	}
	
	@Override
	public String getResult() {
		return String.format("%d", sumOfMultiplesOf(3, null, 1000) + sumOfMultiplesOf(5, 3, 1000)); 
		
	}
	
	
	
	
}
