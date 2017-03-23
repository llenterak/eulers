package org.sealoflove.zero.two;

import java.util.Collections;
import java.util.List;

import org.sealoflove.ArrayUtils;
import org.sealoflove.Task;

public class Task022 implements Task {

	
	
	List<String> names = ArrayUtils.readNamesFromFile("/home/llenterak/workspace/git/euler/src/task022.txt");
	
	
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
