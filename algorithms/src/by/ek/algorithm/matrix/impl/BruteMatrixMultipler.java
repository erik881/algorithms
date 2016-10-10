package by.ek.algorithm.matrix.impl;

import by.ek.algorithm.matrix.MultiplyMatrix;

/**
 * Brute matrix multiplier
 * 
 * 
 * @author Evgeni_Kisel
 *
 */
public class BruteMatrixMultipler implements MultiplyMatrix {

	@Override
	public int[][] multiply(int[][] first, int[][] second) {
		int[][] result = new int[first.length][second[0].length];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				for (int k = 0; k < first[i].length; k++) {
					result[i][j] += first[i][k] * second[k][j];
				}
			}
		}
		
		return result;
	}

}
