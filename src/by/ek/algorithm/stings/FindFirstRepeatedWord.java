package by.ek.algorithm.stings;

import java.util.*;

/**
 * @author Evgeni_Kisel
 */
public class FindFirstRepeatedWord {

	public static void main(String[] args) {
		System.out.println(findFirstRepeatedWord("I had been there for a while.... But then we had decided smth. "));
	}

	private static final Set<Character> SEPARTORS;

	static  {
		Set<Character> separators = new HashSet<>();
		separators.add(' ');
		separators.add('	');
		separators.add(',');
		separators.add(':');
		separators.add(';');
		separators.add('.');
		SEPARTORS = Collections.unmodifiableSet(separators);
	}

	private static String findFirstRepeatedWord(String sentence) {
		Set<String> foundWords = new HashSet<>();
		char[] array = sentence.toCharArray();

		int wordStart = -1;

		for (int i = 0; i < array.length; i++) {
			if (isSeparator(array[i])) {
				if (wordStart > -1) {
					String word = String.valueOf(Arrays.copyOfRange(array, wordStart, i));
					if (foundWords.contains(word)) {
						return word;
					} else {
						foundWords.add(word);
					}
					wordStart = -1;
				}

			} else if (wordStart == -1) {
				wordStart = i;
			}
		}

		return "";
	}

	private static boolean isSeparator(char c) {
		return SEPARTORS.contains(c);
	}
}
