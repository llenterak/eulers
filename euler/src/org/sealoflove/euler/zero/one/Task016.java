package org.sealoflove.euler.zero.one;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.sealoflove.euler.Task;

public class Task016 implements Task {

	public static String sumDigits(String input, int chunk) {
		BigDecimal res = new BigDecimal("0");
		for (int i = 0; i < input.length(); i++) {
			res = res.add(new BigDecimal("" + input.charAt(i)));
			
		}
		return res.toString();
		
	}
	
	@Override
	public String getResult() {
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		res.put(2, 1000);
		String bdr = Task015.result(res).toString();
		return sumDigits(bdr, 10);
	}

}
