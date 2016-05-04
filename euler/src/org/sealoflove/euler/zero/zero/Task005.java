package org.sealoflove.euler.zero.zero;

import org.sealoflove.euler.Task;

public class Task005 implements Task {

	
	private int getCommonMultiple(int limit) {
		return 19 * 17 * 16 * 13 * 11 * 9 * 7 * 5;
	}
	
	
	@Override
	public String getResult() {

		return String.format("%d", getCommonMultiple(20));
	}

}
