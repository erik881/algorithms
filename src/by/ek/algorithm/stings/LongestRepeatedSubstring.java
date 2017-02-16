package by.ek.algorithm.stings;

import java.util.Arrays;

/**
 * @author Evgeni Kisel
 */
public class LongestRepeatedSubstring {

	public static void main(String[] args) {
		System.out.println(longestRepeatedSubstring("banaccc1ccaaccccc"));
	}

	private static String longestRepeatedSubstring(String value) {
		String[] suffixes = new String[value.length()];

		for (int i = 0; i < value.length(); i++) {
			suffixes[i] = value.substring(i);
		}

		Arrays.sort(suffixes);

//		for (String v : suffixes) {
//			System.out.println(v);
//		}

		String biggestRepeated = "";
// suffixes arrays. the main idea is that array sorted by first value and arrays are compared starting for start


		for (int i = 0; i < suffixes.length - 1; i++) {
			int length = compareSuffixes(suffixes[i], suffixes[i + 1]);
			if (length >= 0&& length > biggestRepeated.length()) {
				biggestRepeated = suffixes[i].substring(0, length);
			}
		}


		return biggestRepeated;
	}

	private static int compareSuffixes(String suffix1, String suffix2) {
		int i = 0;
		for (i = 0; i < suffix1.length() && i < suffix2.length(); i++) {
			if (suffix1.charAt(i) != suffix2.charAt(i)) {
				return i;
			}
		}

		return i;
	}
}
