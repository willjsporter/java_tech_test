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

    @Test
    public void arrayWithMultipleElementsShouldReturnNearestDistance() {
        arrayDistance testArrayDistance = new arrayDistance(5, 100, 22, 75, 25, 1001);
        MatcherAssert.assertThat(testArrayDistance.distClosestNumbers(), CoreMatchers.is(3));
    }
}
