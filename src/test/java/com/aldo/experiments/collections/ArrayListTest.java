package com.aldo.experiments.collections;

import com.aldo.experiments.collections.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
    private ArrayList<Integer> al;

    @Before
    public void setUp() throws Exception {
        al = new ArrayList<>();
        for (int i = 0; i <= 10; i++)
            al.add(i);
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(new Integer(5), al.get(5));
        Assert.assertEquals(new Integer(10), al.get(10));
    }

    @Test
    public void testRemove() {
        al.removeAt(5);
        Assert.assertEquals(new Integer(6), al.get(5));
        Assert.assertEquals(null, al.get(10));
    }

    @Test
    public void testInsertAt() {
        al.insert(99, 5);
        Assert.assertEquals(new Integer(99), al.get(5));
        Assert.assertEquals(new Integer(10), al.get(11));
    }

}
