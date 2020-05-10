package app.testFiles;

import java.util.Arrays;
import java.util.Comparator;

public class longestPalindrome {
	public String testData;

	public longestPalindrome(String testData){
		this.testData = testData;
	}

	public String returnLongestPalindrome(){
		final String[] wordsArray = this.testData.split("\\s");

		return Arrays.stream(wordsArray)
			.filter(this::isPalindrome)
			.max(Comparator.comparingInt(String::length))
			.orElse("");
	}

	private boolean isPalindrome(String word) {
		return word.equals(new StringBuilder(word).reverse().toString());
	}
}
