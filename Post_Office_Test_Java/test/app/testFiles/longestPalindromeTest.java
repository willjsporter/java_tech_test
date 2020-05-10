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
}
