package org.sealoflove.euler.zero.one;

import java.math.BigInteger;
import java.util.List;

import org.sealoflove.euler.ArrayUtils;
import org.sealoflove.euler.Task;

public class Task013 implements Task {

	List<BigInteger> vals = ArrayUtils.readArrayOfBigDecimalsFromFile("/home/llenterak/dg/workspace/euler/src/task013.txt");
	
	private BigInteger getSum(List<BigInteger> vals) {
		BigInteger sum = new BigInteger("0");
		for (BigInteger val : vals) {
			sum = sum.add(val);
		}
		return sum;
	}
	
	
	@Override
	public String getResult() {
		
		return String.format("%s", getSum(vals));
	}

}
