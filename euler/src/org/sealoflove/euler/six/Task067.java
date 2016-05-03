package org.sealoflove.euler.six;

import java.util.List;

import org.sealoflove.euler.Task;
import org.sealoflove.euler.two.Task018;

public class Task067 implements Task {

	
	List<List<Integer>> triangle = Task018.readTriangleFromFile("/home/llenterak/workspace/git/euler/src/task67.txt");

	
	
	@Override
	public String getResult() {
		return String.format("%d", Task018.getMaxLength(triangle));
	}

}
