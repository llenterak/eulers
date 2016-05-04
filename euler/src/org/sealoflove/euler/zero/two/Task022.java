package org.sealoflove.euler.zero.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.sealoflove.euler.Task;

public class Task022 implements Task {

	public static List<String> readNamesFromFile(String path) {
		List<String> res = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEachOrdered(z -> {
				res.addAll(Arrays.stream(z.split(",")).map(y -> y).collect(Collectors.toList()));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	List<String> names = readNamesFromFile("/home/llenterak/workspace/git/euler/src/task022.txt");
	
	
	private static Integer score(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - 'A' + 1; 
		}
		return sum;
	}
	
	
	private Long computeScores() {
		Collections.sort(names);
		Long sum = 0l;
		for (int i = 0; i < names.size(); i++) {
			sum += score(names.get(i)) * (i+1);
		}
		return sum;
	}
	
	
	@Override
	public String getResult() {
		
		return String.format("%d", computeScores());
	}

}
