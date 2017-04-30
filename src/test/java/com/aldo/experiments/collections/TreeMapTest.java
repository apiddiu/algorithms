package com.aldo.experiments.collections;

import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Random;
import java.util.ArrayList;

public class TreeMapTest {
    private static int ELEMENTS_COUNT = 100;
    private TreeMap<Integer> head;

    @Before
    public void setUp() throws Exception {
        ArrayList<Integer> elements = new ArrayList<>();

        for (int i = 1; i <= ELEMENTS_COUNT; i++)
            elements.add(i);

        Random r = new Random(Instant.now().getEpochSecond());

        head = new TreeMap<>(elements.remove(r.nextInt(elements.size() - 1)));

        while (elements.size() > 1) {
            head.insert(elements.remove(r.nextInt(elements.size() - 1)));
        }
        head.insert(elements.remove(0));

        System.out.println();
    }

    @Test
    public void sort() throws Exception {
        head.sorted(System.out::println);
    }
}
