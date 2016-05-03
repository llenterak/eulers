package org.sealoflove.euler.two;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import org.sealoflove.euler.Task;

public class Task014 implements Task {


	
	
	class Node {
		int depth;
		int val;
		
	}

	private Long getNextStep(Long val) {
		if (val % 2 == 0)
			return val / 2;
		return 3*val + 1;
	}
	
	
	TreeMap<Long, Integer> nodes = new TreeMap<>();
	
//	private void printSteps(Long val) {
//		System.out.print(val + "-> ");
//		if (val != 1l)
//			printSteps(getNextStep(val));
//	}
	
	private Long getLongestChain(int limit) {
		
		nodes.put(1l,1);
		for (Long i = 2l; i < limit; i++) {
			Long val = i;
			Stack<Long> stacked = new Stack<>();
			//populate the stack
			while (nodes.get(val) == null){
				stacked.push(val);
				val = getNextStep(val);
			}
			//ok, by now we've found one that exists - resolve the stack
			int baseDepth = nodes.get(val); 
			
			while (!stacked.isEmpty()) {
				nodes.put(stacked.pop(), baseDepth + 1);
				baseDepth++;
			}
		}
		int max = 0;
		Long maxStarter = null;
		for (Map.Entry<Long, Integer> entry : nodes.entrySet()) {
			if (max < entry.getValue()) {
				max = entry.getValue();
				maxStarter = entry.getKey();
			}
		}
//		printSteps(maxStarter);
		return maxStarter; 
	}
	
	
	
	@Override
	public String getResult() {
		return String.format("%d", getLongestChain(1000000));
	}

}
