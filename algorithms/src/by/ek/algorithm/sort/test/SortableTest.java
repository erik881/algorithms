package by.ek.algorithm.sort.test;

import static org.junit.Assert.*;

import org.junit.Test;

import by.ek.algorithm.sort.Sortable;

public abstract class SortableTest {

	private Sortable sortable;
	
	public SortableTest(Sortable sortable) {
		this.sortable = sortable;
	}
	
	@Test
	public void testSort() {
		int[] array = new int[] { 88, 11, 42, 65, 101, 11, 4, 88, 69 };
		int[] expected = new int[] { 4, 11, 11, 42, 65, 69, 88, 88, 101 }; 
		int[] actuals = sortable.sort(array);
		assertArrayEquals(expected, actuals);
	}
	
}
