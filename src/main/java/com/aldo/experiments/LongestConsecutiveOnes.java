package com.aldo.experiments;

import java.util.Scanner;

public class LongestConsecutiveOnes {

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            System.out.println(longestSequence(sc.nextInt()));
            t--;
        }
    }

    public static int longestSequence(int i) {
        int longestSequence = 0;
        int currentRun = 0;

        while (i > 0) {
            if (i % 2 > 0) {
                currentRun++;
                if (currentRun > longestSequence)
                    longestSequence = currentRun;
            } else {
                currentRun = 0;
            }

            i /= 2;
        }

        return longestSequence;
    }
}
