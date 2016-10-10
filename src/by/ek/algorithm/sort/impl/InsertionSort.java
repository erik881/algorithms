package by.ek.algorithm.sort.impl;

import by.ek.algorithm.sort.Sortable;

/**
 * Efficient for sorting small number of elements
 * 
 * O(n^2)
 * 
 * @author Evgeni_Kisel
 *
 */
public class InsertionSort implements Sortable {

	@Override
	public int[] sort(int[] array) {
		for (int currentPosition = 1; currentPosition < array.length; currentPosition++) {
			int currentValue = array[currentPosition];
			int newPosition = currentPosition - 1;
			while(newPosition >= 0 && array[newPosition] >= currentValue) {
				array[newPosition + 1] = array[newPosition];
				newPosition--;
			}
			array[newPosition + 1] = currentValue;
		}
		
		return array;
	}

}
