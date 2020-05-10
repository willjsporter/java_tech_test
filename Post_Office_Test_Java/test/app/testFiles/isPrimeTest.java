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
}
