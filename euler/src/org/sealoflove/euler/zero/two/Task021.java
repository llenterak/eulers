package org.sealoflove.euler.zero.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sealoflove.euler.Task;

public class Task021 implements Task {

	
	private List<Set<Integer>> numbers = new ArrayList<Set<Integer>>();
	private Map<Integer, Integer> sums = new HashMap<>();
	
	
	private Integer sumSet(Set<Integer> set) {
		Integer s = 0;
		for (Integer e : set)  {
			s += e;
		}
		return s;
	}
	
	private void populateMap(int limit) {
		for (int i = 0; i < limit; i++) {
			numbers.add(new HashSet<>());
		}
		
		for (int i = 2; i < limit; i++){
			numbers.get(i).add(1);
			int p = i;
			while (p * i < limit){
				numbers.get(p * i).add(p);
				numbers.get(p * i).add(i);
				p++;
			}
		}
		populateSums();
	}
	
	private void populateSums() {
		for (int i = 0; i < numbers.size(); i++) { 
			sums.put(i, sumSet(numbers.get(i)));
		}
	}
	
	private Long calculateSum(int limit) {
		Long res = 0l;
		populateMap(limit);
		for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
			Integer aSum = entry.getValue();
			Integer bSum = sums.get(aSum);
			
			if (entry.getKey().equals(bSum)) {
				
				if (!aSum.equals(bSum)){				
					res += aSum;
					System.out.println(String.format("%d %d",entry.getKey(), aSum));
					res += bSum;
				}
				entry.setValue(0);
				sums.put(aSum, 0);
			}
			
			
		}
		return res;
	}
	
	@Override
	public String getResult() {

		return String.format("%d", calculateSum(10000));
	}

}
