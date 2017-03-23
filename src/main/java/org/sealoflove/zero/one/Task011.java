package org.sealoflove.zero.one;

import org.sealoflove.Task;
import org.sealoflove.ArrayUtils;

public class Task011 implements Task {

	//String fileName = "/home/llenterak/dg/workspace/euler/src/task011.txt";
	
	Integer[][] array = ArrayUtils.toArray(ArrayUtils.readSquareArrayFromFile("/home/llenterak/dg/workspace/euler/src/task011.txt"));
	
	
	
	
	private Integer getMaxProd(int factors) {
		
		int max = 0;
		int n = array.length;
		if (factors > n)
			throw new RuntimeException("nr of factors too large!");
		//horiz
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - factors + 1; j++) {
				int prod = 1;
				for (int k = 0; k < factors; k++) {
					prod *= array[i][j+k];
				}
				if (max < prod)
					max = prod;
			}
		}
		//vertical
		for (int i = 0; i < n - factors + 1; i++) {
			for (int j = 0; j < n; j++) {
				int prod = 1;
				for (int k = 0; k < factors; k++) {
					prod *= array[i+k][j];
				}
				if (max < prod)
					max = prod;
			}
		}
		//main diagonal
		for (int i = 0; i < n - factors + 1; i++) {
			for (int j = 0; j < n - factors + 1; j++) {
				int prod = 1;
				for (int k = 0; k < factors; k++) {
					prod *= array[i+k][j+k];
				}
				if (max < prod)
					max = prod;
			}
		}
		//secondary diagonal
		for (int i = 0; i < n - factors + 1; i++) {
			for (int j = factors; j < n; j++) {
				int prod = 1;
				for (int k = 0; k < factors; k++) {
					prod *= array[i+k][j-k];
				}
				if (max < prod)
					max = prod;
			}
		}
		
		
		return max;
	}
	
	
	private void printArray() {
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array.length; j++) {
				System.out.print(String.format("%2d ", array[i][j]));
			}
			System.out.println();
		}
	}
	
	@Override
	public String getResult() {
		return String.format("%d", getMaxProd(4));
	}

}
