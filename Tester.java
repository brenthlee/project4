/*
 * Brent Lee (blee96)
 * Kaitlin Bleich (kbleich)
 * 11/05/2018
 * Project 4
 */

import java.util.*;

public class Tester {

    public static void main(String[] args) {
        Map<String, int[]> map = new HashMap<>();
        int[] US = {100, 50, 25, 10, 5, 1};
        int[] Soviet = {100, 50, 20, 15, 10, 5, 3, 2, 1};
        int[] powers = {64, 32, 16, 8, 4, 2, 1};
        int[] USnonickel = {100, 50, 25, 10, 1};
        int[] random = {66, 35, 27, 18, 10, 1};
        int sum = 0; //totals matched between the 2 algorithms
        int[] dp = new int[0];
        int[] greedy = new int[0];
        System.out.println("Testing change_DP and change_greedy algorithms");
        for (int n = 1; n <= 200; n++) {
            dp = ChangeMaker.change_DP(n, US);
            greedy = ChangeMaker.change_greedy(n, US);
            int i;
            for (i = 0; i < greedy.length; i++) {
                if(greedy[i] != dp[i])
                {
                  break;
                }
            }
            if (i == greedy.length)
            {
               sum++;
            }
        }
        System.out.println("Testing set1: " + sum + " matches in 200 tests");
        sum = 0;
        for (int n = 1; n <= 200; n++) {
            dp = ChangeMaker.change_DP(n, Soviet);
            greedy = ChangeMaker.change_greedy(n, Soviet);
            int i;
            for (i = 0; i < greedy.length; i++) {
                if(greedy[i] != dp[i])
                {
                  break;
                }
            }
            if (i == greedy.length)
            {
               sum++;
            }
        }
        System.out.println("Testing set2: " + sum + " matches in 200 tests");
        sum = 0;
        for (int n = 1; n <= 200; n++) {
            dp = ChangeMaker.change_DP(n, powers);
            greedy = ChangeMaker.change_greedy(n, powers);
            int i;
            for (i = 0; i < greedy.length; i++) {
                if(greedy[i] != dp[i])
                {
                  break;
                }
            }
            if (i == greedy.length)
            {
               sum++;
            }
        }
        System.out.println("Testing set3: " + sum + " matches in 200 tests");
        sum = 0;
        for (int n = 1; n <= 200; n++) {
            dp = ChangeMaker.change_DP(n, USnonickel);
            greedy = ChangeMaker.change_greedy(n, USnonickel);
            int i;
            for (i = 0; i < greedy.length; i++) {
                if(greedy[i] != dp[i])
                {
                  break;
                }
            }
            if (i == greedy.length)
            {
               sum++;
            }
        }
        //should be about 130 matches and 72 matches
        System.out.println("Testing set4: " + sum + " matches in 200 tests");
        sum = 0;
        for (int n = 1; n <= 200; n++) {
            dp = ChangeMaker.change_DP(n, random);
            greedy = ChangeMaker.change_greedy(n, random);
            int i;
            for (i = 0; i < greedy.length; i++) {
                if(greedy[i] != dp[i])
                {
                  break;
                }
            }
            if (i == greedy.length)
            {
               sum++;
            }
        }
        System.out.println("Testing set5: " + sum + " matches in 200 tests\n");
        
    }
}
