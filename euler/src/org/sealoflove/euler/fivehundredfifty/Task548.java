package org.sealoflove.euler.fivehundredfifty;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sealoflove.euler.Task;

public class Task548 implements Task {

	
	public class Node implements Comparable<Node>{
		public BigDecimal val;
		List<Node> children;
		BigDecimal references;
		
		public void incReferences() {
			references.add(BigDecimal.ONE);
		}
		
		public Node(BigDecimal val) {
			this.val = val;
			references = BigDecimal.ZERO;
		}
		
		@Override
		public String toString() {
			return String.format("<%s: %s>", val.toString(), children.toString());
		}
		public void addChild(Node node) {
			this.children.add(node);
			node.incReferences();
		}
		
		@Override
		public int compareTo(Node o) {
			return this.val.compareTo(o.val);
		}
		
		
	}
	
	Map<Integer, Node> flatNodes = new HashMap<>();
	
	public void populateGraph(int limit) {
		Node first = new Node(new BigDecimal("1"));
		flatNodes.put(1, first);
		for (int i = 1; i < limit; i++ ) {
			for (int j = i; j < limit; j++) {
				BigDecimal factor1 = new BigDecimal(i);
				BigDecimal factor2 = new BigDecimal(j);
				BigDecimal result = factor1.multiply(factor2);
				Integer key = result.intValue();
				if (flatNodes.containsKey(key)) {
					Node node = flatNodes.get(key);
					node.incReferences();
				}
			}
		}
		System.out.println(flatNodes);
	}
	
	
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}

	
