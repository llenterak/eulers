package org.sealoflove.euler.two;

import org.sealoflove.euler.Task;

public class Task012 implements Task {

	
	//get first triangle number that has >500 divisors
	
	
	private int getDivCount(Long n) {
		//sqrt(n) to be treated separately, since a corner case
		int count = 0;
		Long stopValue = new Double(Math.sqrt(n)).longValue();
		for (Long i = 1l; i < stopValue; i++) {
			if (n % i == 0)
				count += 2;
		}
		if (n % stopValue == 0)
			count++;
		return count;
	}
	
	
	private Long getDesiredNumber(int maxDivisorCount) {
		Long number = 1l;
		int divCount = 1;
		Long i = 1l;
		while (divCount <= maxDivisorCount) {
//			System.out.println(number);
			number += (i+1);
			i++;
			divCount = getDivCount(number);
		}
		
		
		return number;
	}
	
	
	
	
	@Override
	public String getResult() {

		return String.format("%d", getDesiredNumber(500));
	}

}
