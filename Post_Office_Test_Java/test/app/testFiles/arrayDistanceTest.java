package app.testFiles;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class arrayDistanceTest {
    @Test
    public void arrayWithTwoElementsShouldReturnDistanceBetweenThoseTwoElements() {
        arrayDistance testArrayDistance = new arrayDistance(5, 1);
        MatcherAssert.assertThat(testArrayDistance.distClosestNumbers(), CoreMatchers.is(4));
    }
}
