package org.sealoflove.zero.two;

import org.sealoflove.Task;

public class Task028 implements Task {

	private static boolean isDiagonal(int i, int j, int limit) {
		if (i == j)
			return true;
		if (i + j - 1 == limit)
			return true;
		return false;
	}
	
	private long calculateSpiralDiagonalSum(int limit) {
		if (limit % 2 != 1)
			throw new RuntimeException();
		long res = 0l;
		
		int c = 1;
		
		int i = limit / 2 + 1;
		int j = limit / 2 + 1;
		int dj = 2;
		int di = 1;
		
		int[] deltas = {-1, 0, 1, 0};
		
		int segment = 2;		
		while (c <= limit * limit) {
			int is = 0;

			while (is < segment / 2) {

				if (isDiagonal(i, j, limit)) {
//					System.out.print(String.format(" [%d] ", c));
					res += c;
				} else {
//					System.out.print(String.format("  %d  ", c));
				}
				c++;
				is++;
				int bi = deltas[di % 4];
				int bj = deltas[dj % 4];
//				System.out.print(String.format("(%d %d)", bi, bj));
				i += bi;
				j += bj;
			}
//			System.out.println();
			segment++;
			di++;
			dj++;
			
		}
		
		return res;
	}
	
	@Override
	public String getResult() {
		
		return String.format("%d", calculateSpiralDiagonalSum(1001));
	}

}
