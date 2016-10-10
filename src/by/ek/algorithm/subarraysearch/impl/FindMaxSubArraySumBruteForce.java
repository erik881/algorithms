package by.ek.algorithm.subarraysearch.impl;

import by.ek.algorithm.subarraysearch.SubArraySearch;
import by.ek.algorithm.subarraysearch.SubArraySearchResult;

/**
 * Finding max difference b/w start and end using brute force 
 * 
 * O(n^2)
 * 
 * @author Evgeni_Kisel
 *
 */
public class FindMaxSubArraySumBruteForce implements SubArraySearch {

	@Override
	public SubArraySearchResult find(int[] array) {
		int startIndex = 0;
		int endIndex = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < array.length; i++) {
			int sum = array[i];
			for (int j = i + 1; j < array.length; j++) {
				sum += array[j];
				if (maxSum <= sum) {
					maxSum = sum;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		return new SubArraySearchResult(startIndex, endIndex);
	}

}
