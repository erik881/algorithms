package by.ek.algorithm.matrix.test;

import static org.junit.Assert.*;

import org.junit.Test;

import by.ek.algorithm.matrix.MultiplyMatrix;

public abstract class SquareMatrixMultiplyTest {

	private final MultiplyMatrix matrixMultiplier;
	
	public SquareMatrixMultiplyTest(MultiplyMatrix matrixMultiplier) {
		this.matrixMultiplier = matrixMultiplier;
	}
	
	
	@Test
	public void test() {
		int[][] first = new int[][] {
			{1, 0},
			{2, 1}
		};
		int[][] second = new int[][] {
			{5, 4},
			{-5, 1}
		};
		int[][] expected = new int[][] {
			{ 5, 4 },
			{ 5, 9 }
		};
		
		int[][] actual = matrixMultiplier.multiply(first, second);
		assertEquals(2, actual.length);
		assertArrayEquals(expected[0], actual[0]);
		assertArrayEquals(expected[1], actual[1]);
	}
}
