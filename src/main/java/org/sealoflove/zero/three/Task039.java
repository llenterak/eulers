package org.sealoflove.zero.three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.sealoflove.Task;

public class Task039 implements Task {

	
	class Triplet implements Comparable<Triplet>{
		int[] nums = new int[3];
		
		public Triplet(int a, int b, int c) {
			nums[0] = a;
			nums[1] = b;
			nums[2] = c;
			Arrays.sort(nums);
		}

		@Override
		public String toString() {
			return String.format("{%d, %d, %d}", nums[0], nums[1], nums[2]);
		}
		
		@Override
		public int compareTo(Triplet o) {
			for (int i = 0; i < 3; i++)
				if (nums[i] != o.nums[i])
					return nums[i] - o.nums[i];
			return 0;
		}
		
		@Override
		public boolean equals(Object o) {
			Triplet t = (Triplet) o;
			return this.compareTo(t) == 0;
		}
		
		@Override
		public int hashCode() {
			return nums[0] * 1000 + nums[1] + nums[2] * 1000000;
		}
		
		
	}
	
	Map<Integer, Set<Triplet>> confs = new HashMap<>();
	
	//returns null if root is non-integer
	//squares of trivial numbers can be placed in a lookup table for opt
	private static Integer sqrt(int n) {
		int res = new Double(Math.sqrt(n)).intValue();
		if (res * res != n)
			return null;
		return res;
	}
	
	private int genConfs(int n) {
//		int limit = Math.sqrt(n)
		for (int a = 1; a < n - 2; a++) {
			for (int b = 1; b < n - 2; b++) {
				Integer c = sqrt(a*a + b*b);
				if (c != null && a + b + c < n) {
					if (!confs.containsKey(a+b+c)) 
						confs.put(a+b+c, new HashSet<Triplet>());
					confs.get(a+b+c).add(new Triplet(a,b,c));
				}
			}
		}
		
		int max = 0;
		int imax = -1;
		for (Map.Entry<Integer, Set<Triplet>> entry : confs.entrySet()) {
			if (entry.getValue().size() > max) {
				imax = entry.getKey();
				max = entry.getValue().size();
			}
		}
		return imax;
//		System.out.println(confs);
	}
	
	
	@Override
	public String getResult() {

		return String.format("%d", genConfs(1000));
	}

}
