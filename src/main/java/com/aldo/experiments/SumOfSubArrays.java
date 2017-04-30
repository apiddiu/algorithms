//package com.aldo.experiments;
//
//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class SumOfSubArrays {
//    private static final BigInteger mod = new BigInteger("1000000007");
//
//    public static void main(String[] args) {
//        SumOfSubArrays sosa = new SumOfSubArrays();
//
//        Scanner sc = new Scanner(System.in);
//        int cases = sc.nextInt();
//
//        while (cases > 0) {
//            int elements = sc.nextInt();
//            int[] array = new int[elements];
//
//            for (int i = 0; i < elements; i++) {
//                array[i] = sc.nextInt();
//            }
//
//            System.out.println(normalizeResult(sosa.sumSubArraysFast(elements, array)));
//            cases--;
//        }
//    }
//
//    public static String normalizeResult(BigInteger result) {
//        return result.mod(mod).toString();
//    }
//
//    public BigInteger sumSubArrays(int elements, int[] array) {
//        BigInteger result = BigInteger.ZERO;
//
//        for (int subSize = 1; subSize <= elements; subSize++) {
//            for (int start = 0; start + subSize <= elements; start++) {
//                for (int index = 0; index < subSize; index++) {
//                    result = result.add(BigInteger.valueOf(array[start + index]));
//                }
//            }
//        }
//
//        return result;
//    }
//
//    public BigInteger sumSubArraysFast(int elements, int[] array) {
//        BigInteger result = BigInteger.ZERO;
//
//        for (int i = 0; i < array.length; i++) {
//
//            int gap = Math.min(i, elements - (i + 1));
//
//
//
//
//            result = result.add(BigInteger.valueOf(array[i] * (elements+add)));
//        }
//
//        return result;
//    }
//}