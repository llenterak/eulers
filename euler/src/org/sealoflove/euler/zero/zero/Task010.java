package org.sealoflove.euler.zero.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.sealoflove.euler.Task;

public class Task010 implements Task {

	List<List<Long>> previousBuckets;
	
	
	private List<Long> getPrimesBucket(Long from, Long to) {
		if (to - from > Integer.MAX_VALUE)
			throw new RuntimeException("bad interval");
		Integer interval = new Long(to - from).intValue();
		Long[] vals = new Long[interval];
		for (int i = 0; i < interval; i++)
			vals[i] = from + i;
		
		if (vals[1] == 1)
			vals[1] = 0l;
		
		Long optimizedToValue = new Double(Math.sqrt(to)).longValue();
		
		for (int iBucket = 0; iBucket < previousBuckets.size(); iBucket++){ // for each bucket
			for (int i = 0; i < previousBuckets.get(iBucket).size(); i++) { // for each existing prime in that bucket
				
				Long prime = previousBuckets.get(iBucket).get(i); 
				
				if (prime > optimizedToValue)
					break;
				//mark as null every multiple existing in this bucket
				for (Long j = prime; j < optimizedToValue; j++) {
					Long  destroyedIndex = previousBuckets.get(iBucket).get(i) * j;
					if (destroyedIndex >= from)
						vals[new Long(destroyedIndex - from).intValue()] = 0l;
				}
			}
		}
		//and now, for yourself, if you're the first bucket
		if (previousBuckets.size() == 0) {
			for (Long i = 2l; i < optimizedToValue; i++) {
				for (Long j = 2l; i * j < to; j++) {
					Long  destroyedIndex = i * j;
					if (destroyedIndex >= from)
						vals[new Long(i * j).intValue()] = 0l;
				}
			}
		}
		return Arrays.stream(vals).filter(z -> z != 0l).collect(Collectors.toList());
//		previousBuckets.add(newBucket);
	}
	

	
	private Long getSumOfPrimes(Long limit) {
		previousBuckets = new ArrayList<List<Long>>();
		int numBuckets = new Long(limit / Integer.MAX_VALUE).intValue();
		if (limit % Integer.MAX_VALUE != 0)
			numBuckets++;
		
		Long maxint = new Long(Integer.MAX_VALUE).longValue();
		for (int i = 0; i < numBuckets; i++) {
			List<Long> newBucket = getPrimesBucket(i * maxint, Math.min(limit, numBuckets * (maxint + 1)));
			previousBuckets.add(newBucket);
		}
		Long s = 0l;
		for (int i = 0; i < previousBuckets.size(); i++) {
			s += previousBuckets.get(i).stream().mapToLong(z -> z).sum();
		}
		
//		for (int i = 0; i < previousBuckets.size(); i++) {
//			for (int j = 0; j < previousBuckets.get(i).size(); j++)
//				System.out.print(previousBuckets.get(i).get(j) + " ");
//		}
		
		
		return s;
		
	}
	
	
	
	@Override
	public String getResult() {
		return String.format("%d", getSumOfPrimes(2000000l));
	}

}
