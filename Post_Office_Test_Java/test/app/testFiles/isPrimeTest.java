package app.testFiles;

import org.junit.Test;

import static app.testFiles.isPrime.isNumberPrime;
import static org.junit.Assert.*;

public class isPrimeTest {

    @Test
    public void shouldReturnFalseForACompositeNumber() {
        assertFalse(isNumberPrime(6));
        assertFalse(isNumberPrime(25));
    }

    @Test
    public void shouldReturnFalseFor1() {
        assertFalse(isNumberPrime(1));
    }

    @Test
    public void shouldReturnFalseFor0() {
        assertFalse(isNumberPrime(0));
    }

    @Test
    public void shouldReturnTrueForPrimeNumbers() {
        assertTrue(isNumberPrime(2));
        assertTrue(isNumberPrime(17));
        assertTrue(isNumberPrime(37));
        assertTrue(isNumberPrime(233));
    }
}
