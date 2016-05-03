package org.sealoflove.euler.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sealoflove.euler.Task;

public class Task023 implements Task {

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
	
	private List<Integer> getAbundantNumbers() {
		List<Integer> res = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry: sums.entrySet()) {
			if (entry.getKey() < entry.getValue())
				res.add(entry.getKey());
		}
		return res;
	}
	
	private int calculateSum(int limit) {
//		Long res = 0l;
		populateMap(limit);
		List<Integer> abs = getAbundantNumbers();
		Set<Integer> allNumbers = new HashSet<>();
		for (int i = 1; i < limit; i++) {
			allNumbers.add(i);
		}
		for (int i = 0; i < abs.size(); i++){
			for (int j = i; j < abs.size(); j++){
				Integer target = abs.get(i) + abs.get(j);
				if (allNumbers.contains(target)){
					allNumbers.remove(target);
//					System.out.print(target + " ");
				}
			}
		}
		System.out.println(allNumbers);
		return allNumbers.stream().mapToInt(z -> z).sum();
	}
	
	
	@Override
	public String getResult() {
		
		return String.format("%d", calculateSum(28123));
	}

}
