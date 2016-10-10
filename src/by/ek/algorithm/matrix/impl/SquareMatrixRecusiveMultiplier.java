package by.ek.algorithm.matrix.impl;

import by.ek.algorithm.matrix.MultiplyMatrix;

/**
 * Recursive square matrix multiplier. N*N where N^2
 * @author Evgeni_Kisel
 *
 */
public class SquareMatrixRecusiveMultiplier implements MultiplyMatrix {

	@Override
	public int[][] multiply(int[][] first, int[][] second) {
		//return multiply(first, second, 0, 0, 0, 0, first.length);
		return null;
	}

//	private int[][] multiply(int[][] first,
//			int[][] second,
//			int rowFirst,
//			int colFirst,
//			int rowSecond,
//			int colSecond,
//			int size) {
//		int[][] result = new int[size][size];
//		
//		if (size == 1) {
//			result[0][0] = first[rowFirst][colFirst] * second[rowSecond][colSecond];
//			return result;
//		}
//		
//		int newSize = size / 2;
//		multiply(first, second, rowFirst, colFirst, rowSecond, colSecond, newSize);
//		multiply(first, second, rowFirst, colFirst + newSize, rowSecond + newSize, colSecond, newSize);
//		
//	}
}
