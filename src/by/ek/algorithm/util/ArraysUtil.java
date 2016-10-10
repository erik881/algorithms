package by.ek.algorithm.util;

import java.util.Random;

public class ArraysUtil {

	public static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int) Math.random() * 10000;
		}
		
		return array;
	}
	
	public static int[]  generateRandomArrayWithNegative(int size) {
		Random r = new Random();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = r.nextInt(150);
			if (!r.nextBoolean()) {
				array[i] = array[i] * -1;
			}
		}
		
		return array;
	}
	
	public static int[][] generateMatrix(int n, int m) {
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			result[i] = generateRandomArray(m);
		}
		
		return result;
	}
}
