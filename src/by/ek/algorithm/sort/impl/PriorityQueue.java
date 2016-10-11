package by.ek.algorithm.sort.impl;

import java.util.Arrays;

public class PriorityQueue {

	private int[] array;
	private int heapSize;
	
	public PriorityQueue(int[] array) {
		this.heapSize = array.length;
		this.array = Arrays.copyOf(array, array.length + (int) (heapSize * 0.75));
		init();
	}
	
	public int peek() {
		return array[0];
	}
	
	public int poll() {
		int result = array[0];
		swap(array, 0, heapSize - 1);
		heapSize--;
		heapify(array, 0);
		return result;
	}
	
	public int add(int value) {
		if (heapSize == array.length) {
			array = Arrays.copyOf(array, array.length + (int) (heapSize * 0.75));
		}
		
		heapSize++;
		
	}
	
	private void init() {
		for (int i = heapSize / 2; i >= 0; i--) {
			heapify(array, i);
		}
	}
	
	private void heapify(int[] array, int index) {
		int left = leftIndex(index);
		int right = rightIndex(index);
		int largest = -1;
		
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		} else {
			largest = index;
		}
		
		if (right < heapSize && array[right] > array[largest]) {
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
	
	private void swap(int[] array, int from, int to) {
		int tmp = array[from];
		array[from] = array[to];
		array[to] = tmp;
	}
	
	
	public static void main(String[] args) {		
		PriorityQueue queue = new PriorityQueue(new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 });
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
