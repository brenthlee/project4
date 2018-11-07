/*
 * Brent Lee (blee96)
 * Kaitlin Bleich (kbleich)
 * 11/05/2018
 * Project 4
 */

import java.util.*;

public class ChangeMaker {

    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inFile;
        System.out.println("Enter the number of coin-denominations and the set of coin values:");
        int k = scanner.nextInt();
        int[] denominations = new int[k];
        for (int i = 0; i < k; i++) {
            denominations[i] = -1 * scanner.nextInt();
        }
        Arrays.sort(denominations);
        for (int i = 0; i < k; i++) {
            denominations[i] *= -1;
        }
        int n;
        do {
            System.out.println("Enter a positive amount to be change (enter 0 to quit):");
            n = scanner.nextInt();
            if (n > 0) {
                count = 0;
                int[] saved = change_DP(n, denominations);
                boolean flag = false;
                //System.out.println("DP algorithm results");
                //print(n, flag, saved, denominations);
                count = 0;
                int[] greedy = change_greedy(n, denominations);
                flag = false;
                System.out.println("\nGreedy algorithm results");
                print(n, flag, greedy, denominations);
            }
        } while (n > 0);
        System.out.println("Thanks for playing. Good Bye");
    }

    public static int[] change_DP(int n, int[] d) {
        //int A[] = new int[d.length]; // aux array to hold min values used
        //int C[] = new int[d.length]; // computed values
        int dp[] = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < d.length; i++) {
            for (int j = d[i]; j <= n; j++) {
                dp[j] += dp[j - d[i]];
            }
        }
        return dp;
    }

    public static int[] change_greedy(int n, int[] d) {
        int i = 0;
        int A[] = new int[d.length];
        while (n > 0) {
            if (d[i] > n) {
                i++;
            }
            if (d[i] <= n) {
                n -= d[i];
                A[i]++;
            }
        }
        return A;
    }

    private static void printRes(boolean flag, int[] res, int[] d, int index) {
        if (index < res.length) {
            if (res[index] > 0) {
                if (flag == true) {
                    System.out.print(" + ");
                }
                System.out.print(res[index] + "*" + d[index] + "c");
                flag = true;
            }
            printRes(flag, res, d, index+1);
        }
    }

    private static void print(int n, boolean flag, int[] arr, int[] d) {
        System.out.println("Amount: " + n);
        System.out.print("Optimal distribution: ");
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        //printRes(flag, arr, d, 0);
        System.out.println("Optimal coin count: " + count + "\n");
    }
}
