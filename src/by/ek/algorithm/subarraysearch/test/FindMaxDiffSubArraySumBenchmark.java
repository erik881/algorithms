package by.ek.algorithm.subarraysearch.test;

import java.util.Arrays;
import java.util.List;

import by.ek.algorithm.subarraysearch.SubArraySearch;
import by.ek.algorithm.subarraysearch.impl.FindMaxSubArraySumBruteForce;
import by.ek.algorithm.subarraysearch.impl.FindMaxSubArraySumDivideAndConquer;
import by.ek.algorithm.util.ArraysUtil;

public class FindMaxDiffSubArraySumBenchmark {

	private List<SubArraySearch> searches;
	
	public FindMaxDiffSubArraySumBenchmark() {
		searches = Arrays.asList(new FindMaxSubArraySumBruteForce(), new FindMaxSubArraySumDivideAndConquer());
	}
	
	public void benchmark() {
		int[] small = ArraysUtil.generateRandomArrayWithNegative(10);
		int[] medium = ArraysUtil.generateRandomArrayWithNegative(1000);
		int[] large = ArraysUtil.generateRandomArrayWithNegative(100000);
		
		for (SubArraySearch search : searches) {
			benchmark(search, small);
		}
		
		for (SubArraySearch search : searches) {
			benchmark(search, medium);
		}
		
		for (SubArraySearch search : searches) {
			benchmark(search, large);
		}
	}
	
	
	private void benchmark(SubArraySearch search, int[] array) {
		long start = System.currentTimeMillis();
		search.find(array);
		long end = System.currentTimeMillis();
		System.out.println(search + " array size: " + array.length + " time taken: " + (end-start));
	}
	

	public static void main(String[] args) {
		new FindMaxDiffSubArraySumBenchmark().benchmark();
	}
	
}
