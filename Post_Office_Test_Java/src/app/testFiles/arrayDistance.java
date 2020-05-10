package app.testFiles;

import java.util.Arrays;

public class arrayDistance {

	private int[] testArray;

	public arrayDistance(int ...testData) {
		this.testArray = testData;
	}

	// Returns the distance between the two closest numbers.
	public int distClosestNumbers() {
		Arrays.sort(testArray);
		return testArray[1] - testArray[0];
	}
}
