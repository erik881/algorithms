package by.ek.algorithm.stings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeni_Kisel
 */
public class FindMissingWords {

	public static void main(String[] args) {
		System.out.println(findMissingWords("I love cheese with smell", "love smell"));
	}

	private static List<String> findMissingWords(String first, String second) {
		String[] allWords = first.split(" ");
		String[] secondSentWords = second.split(" ");

		int allWordsIndex = 0;
		int missingWordsIndex = 0;
		int secondSentWordsIndex = 0;
		String[] missingWords = new String[allWords.length - secondSentWords.length];

		for (; allWordsIndex < allWords.length && secondSentWordsIndex < secondSentWords.length; allWordsIndex++) {
			if (allWords[allWordsIndex].equals(secondSentWords[secondSentWordsIndex])) {
				secondSentWordsIndex++;
			} else {
				missingWords[missingWordsIndex] = allWords[allWordsIndex];
				missingWordsIndex = missingWordsIndex + 1;
			}
		}

		for (; allWordsIndex < allWords.length; allWordsIndex++) {
			missingWords[missingWordsIndex] = allWords[allWordsIndex];
			missingWordsIndex = missingWordsIndex + 1;
		}

		return Arrays.asList(missingWords);
	}
}
