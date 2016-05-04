package org.sealoflove.euler.zero.zero;

import java.util.Arrays;

import org.sealoflove.euler.Task;

public class Task002 implements Task {

	
	class FibonacciWave {
		Long[] vals = {0l, 1l, 1l};
		public Long getFront() {
			return vals[2];
		}
		
		public void inc() {
			vals[0] = vals[1] + vals[2];
			rotate();
		}
		
		public void rotate() {
			Arrays.sort(vals);
		}
		
	}
	
	
	private Long getSumOfEvenFibonacciNumbers(long limit) {
		Long s = 0l;
		FibonacciWave fw = new FibonacciWave();
		while (fw.getFront() < limit) {
			if (fw.getFront() % 2 == 0)
				s += fw.getFront();
//			System.out.println(fw.getFront());
			fw.inc();
		}
		return s;
	}
	
	
	@Override
	public String getResult() {
		
		return String.format("%d", getSumOfEvenFibonacciNumbers(4000000l));
	}

}
