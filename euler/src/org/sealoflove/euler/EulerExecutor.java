package org.sealoflove.euler;

import org.sealoflove.euler.zero.three.Task033;



public class EulerExecutor {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String res = new Task033().getResult();
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Result: %s, time: %d ms", res, endTime - startTime));

	}

}
