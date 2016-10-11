package by.ek.algorithm.sort.test;

import java.util.Arrays;
import java.util.List;

import by.ek.algorithm.sort.Sortable;
import by.ek.algorithm.sort.impl.Heapsort;
import by.ek.algorithm.sort.impl.InsertionSort;
import by.ek.algorithm.sort.impl.MergeSort;
import by.ek.algorithm.sort.impl.Quicksort;
import by.ek.algorithm.util.ArraysUtil;

public class SortBenchmarking {

	private List<Sortable> sorters;
	
	public SortBenchmarking() {
		sorters = Arrays.asList(new MergeSort(), new Heapsort(), new InsertionSort(), new Quicksort());
	}
	
	public void benchmark() {
		int[] small = ArraysUtil.generateRandomArray(100);
		int[] medium = ArraysUtil.generateRandomArray(1000);
		int[] large = ArraysUtil.generateRandomArray(100000);
		
		for (Sortable sort : sorters) {
			benchmark(sort, small);
		}
		
		for (Sortable sort : sorters) {
			benchmark(sort, medium);
		}
		
		for (Sortable sort : sorters) {
			benchmark(sort, large);
		}
		
	}
	
	private void benchmark(Sortable sort, int[] array) {
		long start = System.currentTimeMillis();
		sort.sort(array);
		long end = System.currentTimeMillis();
		System.out.println(sort + " array size: " + array.length + " time taken: " + (end-start));
	}
	
	
	public static void main(String[] args) {
		new SortBenchmarking().benchmark();
	}
}
