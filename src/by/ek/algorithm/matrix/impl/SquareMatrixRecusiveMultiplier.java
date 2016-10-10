package by.ek.algorithm.matrix.impl;

import by.ek.algorithm.matrix.MultiplyMatrix;

/**
 * Recursive square matrix multiplier. N*N where N^2
 * 
 * Much weaker then simple linear {@link BruteMatrixMultipler}
 * 
 * 
 * @author Evgeni_Kisel
 *
 */
public class SquareMatrixRecusiveMultiplier implements MultiplyMatrix {

	@Override
	public int[][] multiply(int[][] first, int[][] second) {
		return multiply(first, second, 0, 0, 0, 0, first.length);
	}

	private int[][] multiply(int[][] first,
			int[][] second,
			int rowFirst,
			int colFirst,
			int rowSecond,
			int colSecond,
			int size) {
		int[][] result = new int[size][size];
		
		if (size == 1) {
			result[0][0] = first[rowFirst][colFirst] * second[rowSecond][colSecond];
			return result;
		}
		
		int newSize = size / 2;
		// C11 = MUL(A11,B11)+MUL(A12,B21)
		sumMatrix(result,
				multiply(first, second, rowFirst, colFirst, rowSecond, colSecond, newSize),
				multiply(first, second, rowFirst, colFirst + newSize, rowSecond + newSize, colSecond, newSize),
				0,
				0);
		
		// C12 = MUL(A11,B12)+MUL(A12,B22)
		sumMatrix(result,
				multiply(first, second, rowFirst, colFirst, rowSecond, colSecond + newSize, newSize),
				multiply(first, second, rowFirst, colFirst + newSize, rowSecond + newSize, colSecond + newSize, newSize),
				0,
				newSize);

		// C21 = MUL(A21,B11)+MUL(A22,B21)
		sumMatrix(result,
				multiply(first, second, rowFirst + newSize, colFirst, rowSecond, colSecond, newSize),
				multiply(first, second, rowFirst + newSize, colFirst + newSize, rowSecond + newSize, colSecond, newSize),
				newSize,
				0);

		// C22 = MUL(A21,B12)+MUL(A22,B22)
		sumMatrix(result,
				multiply(first, second, rowFirst + newSize, colFirst, rowSecond, colSecond + newSize, newSize),
				multiply(first, second, rowFirst + newSize, colFirst + newSize, rowSecond + newSize, colSecond + newSize, newSize),
				newSize,
				newSize);
		
		
		return result;
	}
	
	private int[][] sumMatrix(int[][] result, int[][] first, int[][]second, int resultRow, int resultColumn) {
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < second.length; j++) {
				result[i + resultRow][j + resultColumn] = first[i][j] + second[i][j];
			}
		}
		
		return result;
	}
}
