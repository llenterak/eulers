package org.sealoflove;

import org.sealoflove.zero.six.Task060;


public class EulerExecutor {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String res = new Task060().getResult();
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Result: %s, time: %d ms", res, endTime - startTime));

	}

}
