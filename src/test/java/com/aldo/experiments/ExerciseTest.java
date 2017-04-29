package com.aldo.experiments;

import org.junit.Test;

public class ExerciseTest {
    private Exercise et = new Exercise();

    @Test
    public void test(){
        assert  Solution.hasBalancedBrackets("(h[e{l<l>o}]g)()()()(")==0;
        assert Solution.hasBalancedBrackets("()")==1;
        assert Solution.hasBalancedBrackets("({<[v]>})a}")==1;
    }


}
