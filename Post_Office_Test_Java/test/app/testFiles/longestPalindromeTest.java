package app.testFiles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class longestPalindromeTest {

    @Test
    public void shouldReturnEmptyStringIfNoPalindromeInString() {
        longestPalindrome stringWithoutAPalindrome = new longestPalindrome("No palindromes here");
        assertThat(stringWithoutAPalindrome.returnLongestPalindrome(), is(""));
    }

    @Test
    public void ifOnlyOnePalindromeInString_shouldReturnThatPalindrome() {
        longestPalindrome stringWithOnePalindrome = new longestPalindrome("One palindrome in here: abba");
        assertThat(stringWithOnePalindrome.returnLongestPalindrome(), is("abba"));
    }

    @Test
    public void givenMultipleSingleWordPalindromes_shouldReturnLongest() {
        longestPalindrome stringWithOnePalindrome = new longestPalindrome("Several palindromes in here: abba eddde longestoneenotsegnol a");
        assertThat(stringWithOnePalindrome
            .returnLongestPalindrome(), is("longestoneenotsegnol"));
    }

    @Test
    public void givenPalindromesThatSpanMultipleWords_shouldReturnLongestTotalSequence() {
        longestPalindrome stringWithOnePalindrome = new longestPalindrome("Hello olleh but this is longer regnol si siht so the second one wins no 1 on");
        assertThat(stringWithOnePalindrome.returnLongestPalindrome(), is("this is longer regnol si siht"));
    }

    @Test
    public void givenAdjacentPalindromesShouldReturnTheStringOfBothRatherThanJustTheSingleWord() {
        longestPalindrome stringWithOnePalindrome = new longestPalindrome("Only palindrome is repeated: abba abba");
        assertThat(stringWithOnePalindrome.returnLongestPalindrome(), is("abba abba"));
    }
}
