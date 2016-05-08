package org.sealoflove.euler.zero.four;

import java.util.Set;

import org.sealoflove.euler.Task;

public class Task040 implements Task {

	private int getProductOnPositions(int[] positions) {
		int seekPosIndex = 0;
		Integer i = 1;
		int currentPos = 0;
		int res = 1;
		while (seekPosIndex < positions.length) {
			int currentInc = i.toString().length();
			if (currentPos + currentInc > positions[seekPosIndex]) {
				int delta = positions[seekPosIndex] - currentPos;
				int d = i.toString().charAt(delta - 1) - '0';
				res *= d;
				seekPosIndex++;
			}
			currentPos += currentInc;
			i++;
		}
		return res;
	}
	
	@Override
	public String getResult() {
		return String.format("%d", getProductOnPositions(new int[]{10, 100, 1000, 10000, 100000, 1000000})    );
	}

}
