package by.ek.algorithm.matrix.test;

import java.util.Arrays;
import java.util.List;

import by.ek.algorithm.matrix.MultiplyMatrix;
import by.ek.algorithm.matrix.impl.BruteMatrixMultipler;
import by.ek.algorithm.util.ArraysUtil;

public class SquareMatrixMultiplyBenchmark {

	private List<MultiplyMatrix> matrixMultpliers;
	
	public SquareMatrixMultiplyBenchmark() {
		matrixMultpliers = Arrays.asList(new BruteMatrixMultipler());
	}
	
	public void benchmark() {
		int[][] small1 = ArraysUtil.generateMatrix(16, 16);
		int[][] small2 = ArraysUtil.generateMatrix(16, 16);
		int[][] medium1 = ArraysUtil.generateMatrix(256, 256);
		int[][] medium2 = ArraysUtil.generateMatrix(256, 256);
		int[][] large1 = ArraysUtil.generateMatrix(1024, 1024);
		int[][] large2 = ArraysUtil.generateMatrix(1024, 1024);
		
		for (MultiplyMatrix impl : matrixMultpliers) {
			benchmark(impl, small1, small2);
		}
		
		for (MultiplyMatrix impl : matrixMultpliers) {
			benchmark(impl, medium1, medium2);
		}
		
		for (MultiplyMatrix impl : matrixMultpliers) {
			benchmark(impl, large1, large2);
		}
	}
	
	private void benchmark(MultiplyMatrix impl, int[][] first, int[][] second) {
		long start = System.currentTimeMillis();
		impl.multiply(first, second);
		long end = System.currentTimeMillis();
		System.out.println(impl + " array size: " + first.length + " time taken: " + (end-start));
	}
	
	public static void main(String[] args) {
		new SquareMatrixMultiplyBenchmark().benchmark();
	}
}
