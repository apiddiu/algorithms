package com.aldo.experiments.algorithms;

import java.util.Arrays;

public class Sort {
    public void quickSort(int[] a) {
        quickSortImpl(a, 0, a.length - 1);
    }

    private void quickSortImpl(int[] a, int low, int high) {
        if (a == null || a.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = a[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortImpl(a, low, j);

        if (high > i)
            quickSortImpl(a, i, high);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void bubbleSort(int[] a) {
        boolean s = true;
        int l = a.length;

        while (s) {
            s=false;
            for (int i = 1; i < l; i++) {
                if (a[i-1] > a[i ]) {
                    swap(a, i - 1, i);
                    s = true;
                }
            }
            Arrays.stream(a).forEach(e -> System.out.print(e + ", "));
            System.out.println();
            l--;
        }
    }

}
