package by.ek.algorithm.sort.impl;

import java.util.Arrays;
import java.util.PriorityQueue;

import by.ek.algorithm.sort.Sortable;

/**
 * Heapsort algorithm. PriorityQueue uses it
 * 
 * 
 * @author Evgeni_Kisel
 *
 */
public class Heapsort implements Sortable {

	private int heapsize = 0;
	
	@Override
	public int[] sort(int[] array) {
		heapsize = array.length;
		// A[n/2+1 ... n] - are all leaves. need to verify nodes
		for (int i = array.length / 2; i >= 0; i--) {
			heapify(array, i);
		}
		
		// [0] is always the biggest value. as a result the code below move the biggest to the end and reduce heapsize so heapify will not 
		// touch already sorted values
		for (int i = array.length - 1; i >= 1; i--) {
			swap(array, 0, i);
			heapsize = heapsize - 1;
			heapify(array, 0);
		}
		
		return array;
	}
	
	private void heapify(int[] array, int index) {
		int left = leftIndex(index);
		int right = rightIndex(index);
		int largest = -1;
		
		if (left < heapsize && array[left] > array[index]) {
			largest = left;
		} else {
			largest = index;
		}
		
		if (right < heapsize && array[right] > array[largest]) {
			largest = right;
		}
		
		if (largest != index) {
			swap(array, index, largest);
			heapify(array, largest);
		}
	}

	private int leftIndex(int index) {
		return 2 * (index + 1) - 1;
	}
	
	private int rightIndex(int index) {
		return 2 * (index + 1);
	}
	
	private int parentIndex(int index) {
		return index / 2;
	}
	
	private void swap(int[] array, int from, int to) {
		int tmp = array[from];
		array[from] = array[to];
		array[to] = tmp;
	}
	
	public static void main(String[] args) {		
		new Heapsort().sort(new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 });
	}
}
