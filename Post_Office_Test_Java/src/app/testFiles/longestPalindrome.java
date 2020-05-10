package app.testFiles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class longestPalindrome {
	public String testData;

	public longestPalindrome(String testData){
		this.testData = testData;
	}

	public String returnLongestPalindrome(){
		final String[] wordsArray = this.testData.split("\\s");
		List<String> palindromes = Arrays.stream(wordsArray)
			.filter(this::isPalindrome)
			.sorted(Comparator.comparingInt(String::length).reversed())
			.collect(Collectors.toList());

		return palindromes.isEmpty() ? "" : palindromes.get(0);
	}

	private boolean isPalindrome(String word) {
		return word.equals(new StringBuilder(word).reverse().toString());
	}
}
