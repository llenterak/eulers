package org.sealoflove;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayUtils {

	
	
	public static Integer[][] toArray(List<List<Integer>> array) {
		int n = getArraySize(array);
		Integer[][] res = new Integer[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				res[i][j] = array.get(i).get(j);
		return res;
	}
	
	public static int getArraySize(List<List<Integer>> array) {
		int n = array.size();
		for (int i = 0; i < n; i++) {
			if (array.size() != array.get(i).size())
				throw new RuntimeException("array not square!");
		}
		return n;
	}
	
	
	public static List<BigInteger> readArrayOfBigDecimalsFromFile(String path) {
		List<BigInteger> res = new ArrayList<>();
//		List<String> strings = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			res = stream.map(z -> new BigInteger(z)).collect(Collectors.toList());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static List<String> readNamesFromFile(String path) {
		List<String> res = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEachOrdered(z -> {
				res.addAll(Arrays.stream(z.split(",")).map(y -> y.replaceAll("\"", "")).collect(Collectors.toList()));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static List<List<Integer>> readSquareArrayFromFile(String path) {
		List<List<Integer>> res = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEachOrdered(z -> {
				res.add(Arrays.stream(z.split("\\s")).map(y -> Integer.parseInt(y)).collect(Collectors.toList()));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
}
