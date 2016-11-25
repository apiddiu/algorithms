package com.aldo.experiments.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class BracketsBalanceTest {
    @Test
    public void test() {
        Assert.assertEquals(0, BracketsBalance.hasBalancedBrackets("(h[e{lo}!])()()()("));
        Assert.assertEquals(1, BracketsBalance.hasBalancedBrackets("()[]{}<>"));
        Assert.assertEquals(0, BracketsBalance.hasBalancedBrackets("({)}"));
        Assert.assertEquals(0, BracketsBalance.hasBalancedBrackets("()}"));
    }
}
