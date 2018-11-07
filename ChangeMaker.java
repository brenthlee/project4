/*
 * Brent Lee (blee96)
 * Kaitlin Bleich (kbleich)
 * 11/05/2018
 * Project 4
 */

import java.util.*;

public class ChangeMaker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inFile;
        System.out.println("Enter the number of coin-denominations and the set of coin values:");
        int k = scanner.nextInt();
        int[] denominations = new int[k];
        for (int i = 0; i < k; i++) {
            denominations[i] = scanner.nextInt();
        }
        do {
            System.out.println("Enter a positive amount to be change (enter 0 to quit):");
            int n = scanner.nextInt();
            if (n > 0) {
                int[] saved = change_DP(n, denominations);
                System.out.println("DP algorithm results");
                System.out.print("Amount: ");

            }
        } while (n > 0);
        System.out.println("Thanks for playing. Good Bye");
    }

    public static int[] change_DP(int n, int[] d) {
        int A[] = new int[]; // aux array to hold min values used
        int C[] = new int[]; // computed values
        int dp[] = new int[n+1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i+1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int val: d) {
            }
        }
    }
}
