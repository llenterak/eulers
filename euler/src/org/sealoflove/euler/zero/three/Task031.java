package org.sealoflove.euler.zero.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sealoflove.euler.Task;

public class Task031 implements Task {

	/*1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).*/
	//follows the logic of https://andrew.neitsch.ca/publications/m496pres1.nb.pdf
	
	int[] a = {1, 2, 5, 10, 20, 50, 100, 200};

	//number of ways of making change for n cents
	//using only the first k types
	private int f(int n, int k) {
		if (k < 0 || n < 0)
			return 0;
		if (n == 0)
			return 1;
		return f(n, k - 1) + f(n - a[k], k);
	}
	
	@Override
	public String getResult() {
		return String.format("%d", f(200, 7));
	}

}
