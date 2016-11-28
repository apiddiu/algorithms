package com.aldo.experiments;

import java.math.BigInteger;
import java.util.Scanner;

public class SumSubarrays {

    private static final BigInteger module = new BigInteger("1000000007");

    public static void main(String[] args) {
        SumSubarrays ss = new SumSubarrays();
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        // One by one run for all input test cases
        while (cases > 0) {
            // Input the size of the array
            int elements = sc.nextInt();
            int[] arr = new int[elements];

            // Input the array
            for (int i = 0; i < elements; i++)
                arr[i] = sc.nextInt();

            // Compute and print result
            System.out.println(ss.normalizeResult(ss.sumSubarrays(elements, arr)));

            cases--;
        }
    }

    public BigInteger normalizeResult(BigInteger res) {
        return res.mod(module);
    }

    public BigInteger sumSubarrays(int elements, int[] array) {
        BigInteger res = BigInteger.ZERO;

        for (int i = 0, j = elements - 1; i <= j; i++, j--) {

            BigInteger iValue = BigInteger.valueOf(array[i]);
            int occurrences = occurrences(elements, i);

            res = res.add(
                iValue.multiply(BigInteger.valueOf(occurrences)));

            if (i != j) {
                BigInteger jValue = BigInteger.valueOf(array[j]);
                res = res.add(
                    jValue.multiply(BigInteger.valueOf(occurrences)));
            }
        }

        return res;
    }

    public int occurrences(int elements, int index) {

        if (index >= elements) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (elements-index)*(index+1);
//
//        int distance = Math.min(index, elements - (index + 1));
//        int occurrences = elements;
//
//        for (int i = 0; i < distance; i++) {
//            elements = elements - 2 > 0 ? elements - 2 : elements - 1;
//            occurrences += elements;
//        }
//        return occurrences;
    }
}
