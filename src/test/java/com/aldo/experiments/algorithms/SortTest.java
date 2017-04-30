package com.aldo.experiments.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SortTest {
    private static final int ELEMENTS_COUNT = 20;//25000;
    private int array[];
    private Sort sort;

    @Before
    public void setUp() throws Exception {
        array = new int[ELEMENTS_COUNT];

        for(int i=1;i<=ELEMENTS_COUNT;i++)
            array[i-1]=i;

        sort = new Sort();
    }

    @Test
    public void quickSortTest() throws Exception {
        shuffle(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + ", "));
        System.out.println();
        System.out.println();
        System.out.println(Instant.now());
        System.out.println();
        sort.quickSort(array);
        System.out.println(Instant.now());System.out.println();
        System.out.println();
        Arrays.stream(array).forEach(e -> System.out.print(e + ", "));
    }

    @Test
    public void bubbleSortTest() throws Exception {
        shuffle(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + ", "));
        System.out.println();
        sort.bubbleSort(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + ", "));
    }

    private void shuffle(int arr[]){
    Random rnd = new Random();
        int size = arr.length;
        // Shuffle array
        for (int i=size; i>1; i--)
            swap(arr, i-1, rnd.nextInt(i));
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
