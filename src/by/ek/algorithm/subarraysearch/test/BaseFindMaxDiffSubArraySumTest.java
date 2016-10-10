package by.ek.algorithm.subarraysearch.test;

import static org.junit.Assert.*;

import org.junit.Test;

import by.ek.algorithm.subarraysearch.SubArraySearch;
import by.ek.algorithm.subarraysearch.SubArraySearchResult;

public abstract class BaseFindMaxDiffSubArraySumTest {

	private final SubArraySearch search;
	
	public BaseFindMaxDiffSubArraySumTest(SubArraySearch search) {
		this.search = search;
	}
	
	@Test
	public void test() {
		int[] array = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		SubArraySearchResult result = search.find(array);
		assertEquals(7, result.getStartIndex());
		assertEquals(10, result.getEndIndex());
	}
}
