package com.aldo.experiments;

import org.junit.Assert;
import org.junit.Test;

public class BracketsTest {
    @Test
    public void name() throws Exception {
        Assert.assertEquals("YES", Brackets.isBalanced("{}[]()"));

    }
}
