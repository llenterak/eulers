package org.sealoflove.euler.zero.zero;

import org.sealoflove.euler.Task;

public class Task009 implements Task {
	//a*a + b*b = c*c, a+b+c  =1000 
	//find abc
	
	private Integer findNumber(int sum) {
		for (int c = sum - 2; c > 1; c--) {
			int res = sum - c;
			for (int a = res - 1; a > 1; a--) {
				int b = sum - a - c;
				if (a*a + b*b == c*c) {
					System.out.println(String.format("%d + %d + %d = %d",a,b,c,a+b+c ));
					System.out.println(String.format("%d + %d = %d",a*a,b*b,c*c));
					System.out.println(String.format("%d * %d * %d = %d", a,b,c,a*b*c));
					return a*b*c;
				}
			}
		}
		
		return null;
	}
	
	
	@Override
	public String getResult() {

		return String.format("%d", findNumber(1000));
	}

}
