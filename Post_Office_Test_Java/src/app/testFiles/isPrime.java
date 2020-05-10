package app.testFiles;

import java.util.stream.IntStream;

public class isPrime {
	public static Boolean isNumberPrime(int number) {
		if(number < 2) {
			return false;
		} else {
			int maximumPossibleSmallerFactor = new Double(Math.sqrt(number)).intValue();
			return IntStream
				.rangeClosed(2,maximumPossibleSmallerFactor)
				.filter(possibleFactor -> number % possibleFactor == 0)
				.count() == 0;
		}
	}
}
