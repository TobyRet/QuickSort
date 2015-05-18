package com.codurance;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuickStartShould {
    private final QuickSort quickStart = new QuickSort();

    @Test
    public void return_1234_for_3214() {
        List<Integer> expectedSortedArray = asList(1,2,3,4,5,6,7,8,9);
        assertThat(quickStart.sort(823146579), is(expectedSortedArray));
    }

    @Ignore
    @Test
    public void return_12345678_for_523671284() {
        assertThat(quickStart.sort(523671284), is(12345678));
    }
}
