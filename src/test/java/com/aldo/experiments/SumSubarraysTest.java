package com.aldo.experiments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumSubarraysTest {
    private SumSubarrays ss;

    @Before
    public void setUp() throws Exception {
        ss = new SumSubarrays();
    }

    @Test
    public void subArraysSumCalculationTest() {
        Assert.assertEquals(20, ss.sumSubarrays(3,new int[]{1,2,3}).intValue());
    }

    @Test
    public void occurrencesCalculationTest() {
        Assert.assertEquals(1, ss.occurrences(1, 0));

        Assert.assertEquals(2, ss.occurrences(2, 0));
        Assert.assertEquals(2, ss.occurrences(2, 1));

        Assert.assertEquals(3, ss.occurrences(3, 0));
        Assert.assertEquals(4, ss.occurrences(3, 1));
        Assert.assertEquals(3, ss.occurrences(3, 2));

        Assert.assertEquals(7, ss.occurrences(7, 0));
        Assert.assertEquals(12, ss.occurrences(7, 1));
        Assert.assertEquals(15, ss.occurrences(7, 2));
        Assert.assertEquals(16, ss.occurrences(7, 3));
        Assert.assertEquals(15, ss.occurrences(7, 4));
        Assert.assertEquals(12, ss.occurrences(7, 5));
        Assert.assertEquals(7, ss.occurrences(7, 6));
    }
}
