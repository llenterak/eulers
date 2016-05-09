package org.sealoflove.euler;

import org.sealoflove.euler.zero.five.Task050_alt;



public class EulerExecutor {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String res = new Task050_alt().getResult();
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Result: %s, time: %d ms", res, endTime - startTime));

	}

}
