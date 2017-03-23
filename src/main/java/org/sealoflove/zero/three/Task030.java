package org.sealoflove.zero.three;

import org.sealoflove.Task;

public class Task030 implements Task {

	
	int[] powers = {0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049};
	
	
	private Long getSumOfNumber(long n) {
		Long s = 0l;
		while (n > 0) {
			int res = (int)n % 10;
			s += powers[res];
			n = n / 10l;
		}
		return s;
	}
	
	private void getSumOfSums() {
		Long i = 2l;
		Long s = 0l;
		while (true) {
			if (i % 1000000 == 0)
				System.out.println(String.format("As far as %d, sum is %d", i, s));
			Long localS = getSumOfNumber(i); 
			if (i.equals(localS)){
				s += localS;
				System.out.println(i);
			}
			i++;
		}
//		return null;
	}
	
	@Override
	public String getResult() {
		getSumOfSums();
//		for (int i = 1; i <= 9; i++)
//		System.out.print(i*i*i*i*i + ", ");
		// TODO Auto-generated method stub
//		return getSumOfSums();
		return null;
	}

}
