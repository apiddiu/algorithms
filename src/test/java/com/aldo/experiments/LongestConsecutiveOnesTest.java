package com.aldo.experiments;

import org.junit.Test;

import static com.aldo.experiments.LongestConsecutiveOnes.*;
import static org.junit.Assert.assertEquals;

public class LongestConsecutiveOnesTest {
    @Test
    public void testLongestSequence() throws Exception {
        assertEquals(1, longestSequence(17));
        assertEquals(2, longestSequence(3));
        assertEquals(3, longestSequence(7));
        assertEquals(4, longestSequence(15));
    }

    @Test
    public void testLongestSequenceMain() throws Exception {
        main(new String[]{"4", "17", "3", "7", "15"});
    }
}
