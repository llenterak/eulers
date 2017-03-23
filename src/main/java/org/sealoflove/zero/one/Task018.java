package org.sealoflove.zero.one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sealoflove.Task;

public class Task018 implements Task {
	public static List<List<Integer>> readTriangleFromFile(String path) {
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

	List<List<Integer>> triangle = readTriangleFromFile("/home/llenterak/workspace/git/euler/src/task018.txt");
	
	public static long getMaxLength(List<List<Integer>> triangle) {
		Integer[] snowball = new Integer[triangle.size()]; 
		for (int i = 0; i < snowball.length; i++)
			snowball[i] = triangle.get(triangle.size() - 1).get(i);
		for (int row = triangle.size() - 2; row >= 0; row--) {
			List<Integer> currentRow = triangle.get(row);
			for (int i = 0; i < currentRow.size(); i++) {
				int max = Math.max(snowball[i], snowball[i+1]);
				snowball[i] = currentRow.get(i) + max;
			}
		}
		return snowball[0];
	}
	
	@Override
	public String getResult() {
		return String.format("%d", getMaxLength(this.triangle));
	}
}
