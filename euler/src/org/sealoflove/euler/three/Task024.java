package org.sealoflove.euler.three;

import org.sealoflove.euler.Task;

public class Task024 implements Task {

	
	long globalCount =  0l;
	
	private void generatePermutations(String numbersRemaining, String numbersPassed) {
		for (int i = 0; i < numbersRemaining.length(); i++) {
			generatePermutations(numbersRemaining.replace("" + numbersRemaining.charAt(i), ""), numbersPassed + numbersRemaining.charAt(i));
//			String passable =  
		}
		if (numbersRemaining.length() == 0)
			globalCount++;
		if (globalCount == 1000000)
			System.out.println(numbersPassed);
	}
	
	@Override
	public String getResult() {
		generatePermutations("0123456789", "");
		return null;
	}

}
