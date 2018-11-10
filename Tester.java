/*
 * Brent Lee (blee96)
 * Kaitlin Bleich (kbleich)
 * 11/05/2018
 * Project 4
 */

import java.util.*;

public class Tester {

    public static void main(String[] args) {
        int[][] sets = {{100, 50, 25, 10, 5, 1}, //US
                        {100, 50, 20, 15, 10, 5, 3, 2, 1}, //Soviet
                        {64, 32, 16, 8, 4, 2, 1}, //powers of 2
                        {100, 50, 25, 10, 1}, //US no nickel
                        {66, 35, 27, 18, 10, 1}}; //random
        System.out.println("Testing change_DP and change_greedy algorithms");
        for (int i = 0; i < sets.length; i++) {
            int sum = 0;
            for (int n = 1; n <= 200; n++) {
                int[] dp = ChangeMaker.change_DP(n, sets[i]);
                int[] greedy = ChangeMaker.change_greedy(n, sets[i]);
                int j;
                for (j = 0; j < greedy.length; j++) {
                    if(greedy[j] != dp[j]) {
                        break;
                    }
                }
                if (j == greedy.length) {
                    sum++;
                }
            }
            System.out.println("Testing set" + (i+1) + ": " + sum + " matches in 200 tests");
        }
        System.out.println("");
    }
}
