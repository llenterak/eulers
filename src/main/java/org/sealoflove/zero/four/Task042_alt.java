package org.sealoflove.zero.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sealoflove.ArrayUtils;
import org.sealoflove.Task;

public class Task042_alt implements Task {

	List<String> words = ArrayUtils.readNamesFromFile("/home/llenterak/workspace/git/euler/src/task042.txt");
	
	
	
	private static int triangulate(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += (s.charAt(i) - 'A' + 1); 
		}
		return res;
	}
	
	
	private Set<Integer> getTriangularNumbers(int limit) {
		int i = 0;
		Set<Integer> res = new HashSet<>();
		while (i * (i+1) / 2 <= limit) {
			res.add(i * (i+1) / 2);
			i++;
		}
		return res;
	}
	
	
	//done with streams just to have fun with streams; can be done with lots of optimizations
	private long countTriangleWords() {
		Map<String, Integer> wordMap = new HashMap<>();
		int max = 0;
		for (String s : words) {
			int tg = triangulate(s);
//			System.out.println(String.format("%s -> %d", s, tg));
			wordMap.put(s, tg);
			if (max < tg)
				max = tg;
		}
		
		Set<Integer> triNumbers = getTriangularNumbers(max);
		List<Integer> list = new ArrayList<>(triNumbers);
		list.sort(null);
//		System.out.println(list);
		int count = 0;
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			if (triNumbers.contains(entry.getValue())) {
//				System.out.println(String.format("[%s] -> %d", entry.getKey(), entry.getValue()));
				count++;
			}
		}
		
		return count;
	}
	@Override
	public String getResult() {
//		System.out.println(triangulate("SKY"));
		return String.format("%d", countTriangleWords());
	}

}
