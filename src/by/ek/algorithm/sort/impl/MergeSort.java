package by.ek.algorithm.sort.impl;

import java.util.Arrays;

import by.ek.algorithm.sort.Sortable;

/**
 * Divide and conquer 
 * 
 * @author Evgeni_Kisel
 *
 */
public class MergeSort implements Sortable {

	@Override
	public int[] sort(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		
		int middle = array.length / 2;
		int[] leftArray = Arrays.copyOfRange(array, 0, middle);
		int[] rightArray = Arrays.copyOfRange(array, middle, array.length);
		
		leftArray = sort(leftArray);
		rightArray = sort(rightArray);
		
		int arrayIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		// merge
		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				array[arrayIndex++] = leftArray[leftIndex++];
			} else {
				array[arrayIndex++] = rightArray[rightIndex++];
			}
		}
		
		for (int i = leftIndex; i < leftArray.length; i++) {
			array[arrayIndex++] = leftArray[i];
		}
		
		for (int i = rightIndex; i < rightArray.length; i++) {
			array[arrayIndex++] = rightArray[i];
		}
		
		return array;
	}

}
