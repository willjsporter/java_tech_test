package app.testFiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class longestPalindrome {
	public String testData;

	public longestPalindrome(String testData){
		this.testData = testData.toLowerCase();
	}

	public String returnLongestPalindrome(){
		final String[] wordsArray = this.testData.split("\\s");
		List<String> multiwordPalindromeList = new ArrayList<>();

		for(int i = 0; i < wordsArray.length; i ++) {
			if(isPalindrome(wordsArray[i])) {
				String wholePalindrome = checkIfPalindromeIsCentreOfAMultiwordPalindrome(wordsArray, i);
				multiwordPalindromeList.add(wholePalindrome);
			}
			if(i < wordsArray.length - 1) {
				if(word1IsReverseOfWord2(wordsArray[i], wordsArray[i + 1])) {
					String wholePalindrome = checkIfMirroredWordsAreCentreOfAMultiwordPalindrome(wordsArray, i);
					multiwordPalindromeList.add(wholePalindrome);
				}
			}
		}
		return multiwordPalindromeList
			.stream()
			.max(Comparator.comparingInt(String::length))
			.orElse("");
	}

	private boolean isPalindrome(String word) {
		return word1IsReverseOfWord2(word, word);
	}

	private boolean word1IsReverseOfWord2(String word1, String word2) {
		return word1.equals(new StringBuilder(word2).reverse().toString());
	}

	private String checkIfPalindromeIsCentreOfAMultiwordPalindrome(String[] wordsArray, int i) {
		String wholePalindrome = wordsArray[i];
		int numberOfOtherWordsToCheck = Math.min(i, (wordsArray.length - 1) - i);
		return getMaxLengthPalindromeAroundWord(wordsArray, i, wholePalindrome, numberOfOtherWordsToCheck, 0);
	}

	private String checkIfMirroredWordsAreCentreOfAMultiwordPalindrome(String[] wordsArray, int i) {
		String wholePalindrome = wordsArray[i] + " " + wordsArray[i + 1];

		int numberOfOtherWordsToCheck = Math.min(i, (wordsArray.length - 1) - (i + 1));
		return getMaxLengthPalindromeAroundWord(wordsArray, i, wholePalindrome, numberOfOtherWordsToCheck, 1);
	}

	private String getMaxLengthPalindromeAroundWord(String[] wordsArray, int wordPosition, String initialPalindrome, int numberOfWordsToCheckEitherSide, int adjustForInitial2WordPalindrome) {
		for(int j = 1; j <= numberOfWordsToCheckEitherSide; j ++) {
			String maybeExtendedPalindrome = wordsArray[wordPosition - j] + " " + initialPalindrome + " " + wordsArray[wordPosition + adjustForInitial2WordPalindrome + j];
			if(isPalindrome(maybeExtendedPalindrome)) {
				initialPalindrome = maybeExtendedPalindrome;
			} else { break; }
		}
		return initialPalindrome;
	}
}
