package org.sealoflove.euler.zero.four;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sealoflove.euler.ArrayUtils;
import org.sealoflove.euler.Task;

public class Task042 implements Task {

	List<String> words = ArrayUtils.readNamesFromFile("/home/llenterak/workspace/git/euler/src/task042.txt");
	
	
	
	private static int triangulate(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += (s.charAt(i) - 'A' + 1); 
		}
		return res;
	}
	
	
	private Set<Integer> getTriangularNumbers(int limit) {
		Set<Integer> res = new HashSet<>();
		for (int i = 0; i * (i+1) / 2 <= limit; i++) {
			res.add(i * (i+1) / 2);
		}
		return res;
	}
	
	
	//done with streams just to have fun with streams; can be done with lots of optimizations
	private long countTriangleWords() {
		int[] weights = words.stream().mapToInt(z -> triangulate(z)).toArray();
		OptionalInt maxWeight = Arrays.stream(weights).map(z -> z).max();
		
		long count = 0;
		if (maxWeight.isPresent()) {
			Set<Integer> triNumbers = getTriangularNumbers(maxWeight.getAsInt());
			count = words.stream().mapToInt(z -> triangulate(z)).filter(y -> triNumbers.contains(y)).count();
		}
		return count;
	}
	@Override
	public String getResult() {
		return String.format("%d", countTriangleWords());
	}

}
