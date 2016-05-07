package org.sealoflove.euler.zero.nine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sealoflove.euler.Task;

public class Task093 implements Task {

	
	class Group {
		Integer value;
		
		public Group() {
			
		}
		
		
		private Integer runOperation(Integer op1, Integer op2, Operation operation) {
			if ((op1 == null) || (op2 == null))
				return null;
			switch(operation) {
			case DIV:
				if (op1 % op2 != 0) {
					throw new RuntimeException("sequence compromised");
				}
				return op1 / op2;
			case MINUS:
				return op1 - op2;
			case PLUS:
				return op1 + op2;
			case PROD:
				return op1 * op2;
			default:
				return null;
			}
		}	
		
		
		
		
		private void regroup() {

		}
		
		/*value != null only for bottom-level groups*/
		private Integer getValue() {
			if (this.value != null)
				return value;
			regroup();
			Integer res = 0;
			//run div and prod first
			for (int i = 0; i < operations.size(); i++) {
				res += runOperation(operands.get(i).getValue(), operands.get(i + 1).getValue(), operations.get(i));
			}
			
			
			return res;
		}
		
		private List<Group> operands;
		private List<Operation> operations;
	}
	
	
	enum Operation{
		PLUS,
		MINUS,
		PROD,
		DIV;
		public boolean hasPriority() {
			if (this.equals(PLUS) || this.equals(MINUS))
				return false;
			return true;
		}
	}
	
	private Map<String, Integer> results;
	
	
	
	
	
	
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
