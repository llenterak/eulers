package org.sealoflove.zero.two;

import org.sealoflove.Task;

public class Task026 implements Task {
	
	
	int getLongestRecurrentString(int limit) {
		int seqLength = 0;
		int max = -1;
		for (int i = 2; (i < limit) && (seqLength < i); i++) {
			int[] foundRemainders = new int[i];
			int value = 1;
			int pos = 0;
			while (foundRemainders[value] == 0 && value != 0) {
				foundRemainders[value] = pos;
				value *= 10;
				value %= i;
				pos++;
			}
			if (pos - foundRemainders[value] > seqLength) {
				max = i;
				seqLength = pos - foundRemainders[value];
			}
			
		}
		return max;
	}
	
	
	@Override
	public String getResult() {
		return String.format("%d", getLongestRecurrentString(1000));
//		return "";
//		return getLongestRecurrentString("123452342342342");
	}

}
