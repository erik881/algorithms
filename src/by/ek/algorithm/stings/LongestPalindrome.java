package by.ek.algorithm.stings;

import java.util.Arrays;

/**
 * @author Evgeni_Kisel
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(findLongestPalindrome("abcabefgheehgfe1232aaaw"));
	}

	private static String findLongestPalindrome(String value) {
		char[] array = value.toCharArray();
		char[] longestPalindrome = null;


		for (int i = 0; i < array.length - 1; i++) {
			char[] foundPalindrome;
			foundPalindrome = findPalindrome(array, i, i);
			if (isLongerThanPrevious(foundPalindrome, longestPalindrome)) {
				longestPalindrome = foundPalindrome;
			}
			foundPalindrome = findPalindrome(array, i, i + 1);
			if (isLongerThanPrevious(foundPalindrome, longestPalindrome)) {
				longestPalindrome = foundPalindrome;
			}
		}

		return String.valueOf(longestPalindrome);
	}

	private static boolean isLongerThanPrevious(char[] justFound, char[] currentlyLongest) {
		if (currentlyLongest == null) {
			return true;
		}

		return justFound.length > currentlyLongest.length;
	}

	private static char[] findPalindrome(char[] value, int left, int right) {
		while(left >= 0 && right < value.length && value[left] == value[right] ) {
			left--;
			right++;
		}

		return Arrays.copyOfRange(value, left + 1, right);
	}

}
