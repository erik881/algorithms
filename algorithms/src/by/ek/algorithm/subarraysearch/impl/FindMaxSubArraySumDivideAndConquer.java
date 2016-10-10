package by.ek.algorithm.subarraysearch.impl;

import by.ek.algorithm.subarraysearch.SubArraySearch;
import by.ek.algorithm.subarraysearch.SubArraySearchResult;

/**
 * Find max sub array items by divide and conquer
 * 
 * O(n*lg(n))
 * 
 * @author Evgeni_Kisel
 *
 */
public class FindMaxSubArraySumDivideAndConquer implements SubArraySearch {

	@Override
	public SubArraySearchResult find(int[] array) {
		RecursiveResult result = findRecursive(array, 0, array.length - 1);
		return new SubArraySearchResult(result.getStartIndex(), result.getEndIndex());
	}
	
	private RecursiveResult findRecursive(int[] array, int start, int end) {
		if (start == end) {
			return new RecursiveResult(start, end, array[start]);
		}
		
		int mid = (start + end) / 2;
		RecursiveResult leftResult = findRecursive(array, start, mid);
		RecursiveResult rightResult = findRecursive(array, mid + 1, end);
		RecursiveResult crossResult = findCrossSubArray(array, start, end, mid);
		
		if (leftResult.getDiffernce() >= rightResult.getDiffernce() && leftResult.getDiffernce() >= crossResult.getDiffernce()) {
			return leftResult;
		} else if (rightResult.getDiffernce() >= leftResult.getDiffernce() && rightResult.getDiffernce() >= crossResult.getDiffernce()) {
			return rightResult;
		} else {
			return crossResult;
		}
		
		
	}
	
	private RecursiveResult findCrossSubArray(int[] array, int start, int end, int mid) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = 0;
		for (int i = mid; i >= start; i--) {
			sum = sum + array[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = 0;
		for (int i = mid + 1; i <= end; i++) {
			sum = sum + array[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		
		return new RecursiveResult(maxLeft, maxRight, leftSum + rightSum);
	}

	
	
	private static class RecursiveResult { 
		private final int startIndex;
		private final int endIndex;
		private final int differnce;
		
		public RecursiveResult(int start, int end, int diff) {
			this.startIndex = start;
			this.endIndex = end;
			this.differnce = diff;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public int getDiffernce() {
			return differnce;
		}
		
		@Override
		public String toString() {
			return startIndex + " " + endIndex + " " + differnce;
		}
	}
}
