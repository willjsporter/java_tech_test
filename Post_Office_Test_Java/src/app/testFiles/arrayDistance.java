package app.testFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class arrayDistance {

	private int[] testArray;

	public arrayDistance(int ...testData) {
		this.testArray = testData;
	}

	// Returns the distance between the two closest numbers.
	public int distClosestNumbers() {
		Arrays.sort(testArray);
		ArrayList<Integer> distanceArray = new ArrayList<>();

		for(int i = 0; i < (testArray.length -1); i++) {
			distanceArray.add(testArray[i + 1] - testArray[i]);
		}

		return distanceArray.stream()
			.sorted()
			.collect(Collectors.toList())
			.get(0);
	}
}
