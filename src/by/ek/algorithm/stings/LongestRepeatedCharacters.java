package by.ek.algorithm.stings;

import java.util.LinkedHashMap;

/**
 * @author Evgeni Kisel
 */
public class LongestRepeatedCharacters {

	public static void main(String[] args) {
		System.out.println(longestSubString("abcdefg".toCharArray()));
		System.out.println(longestSubString("ababc123".toCharArray()));
		System.out.println(longestSubString("bbbbbbbbbcde".toCharArray()));


	}

	private static String longestSubString(char[] value) {
		LinkedHashMap<Character, Integer> positionMap = new LinkedHashMap<>();
		int longestSubStringSize = 0;
		String longestSubString = null;
		for (int i = 0; i < value.length; i++) {
			if (!positionMap.containsValue(value[i])) {
				positionMap.put(value[i], i);

				if (positionMap.size() > longestSubStringSize) {
					StringBuilder b = new StringBuilder();
					for (char v : positionMap.keySet()) {
						b.append(v);
					}
					longestSubString = b.toString();
					longestSubStringSize = longestSubString.length();
				}

			} else {
				i = positionMap.get(value[i]);
				positionMap.clear();
			}
		}

		return longestSubString;
	}
}
