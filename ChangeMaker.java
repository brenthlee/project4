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
            do {
                System.out.println("\nEnter a positive amount to be changed (enter 0 to quit):");
                n = scanner.nextInt();
            } while (n < 0);
            if (n > 0) {
                count = 0;
                int[] dp = change_DP(n, denominations);
                boolean flag = false;
                System.out.println("\nDP algorithm results");
                print(n, flag, dp, denominations);
                count = 0;
                int[] greedy = change_greedy(n, denominations);
                flag = false;
                System.out.println("\nGreedy algorithm results");
                print(n, flag, greedy, denominations);
            }
        } while (n > 0);
        System.out.println("\nThanks for playing. Good Bye\n");
    }

    public static int[] change_DP(int n, int[] d) {
        int[] A = new int[n+1]; // aux array to hold min values used
        int[] C = new int[n+1]; // computed values
        C[0] = 0;
        A[0] = 1;
        for (int j = 1; j <= n; j++) {
            int minCoins = j;
            int newCoin = 1;
            for (int i = 0; i < d.length; i++) {
                if (d[i] > j) {
                    continue;
                }
                if (C[j - d[i]] + 1 < minCoins) {
                    minCoins = C[j - d[i]] + 1;
                    newCoin = d[i];
                }
            }
            C[j] = minCoins;
            A[j] = newCoin;
        }
        count = C[n];
        int[] B = getAnsDP(A, C, n, d);
        return B;
    }

    private static int[] getAnsDP(int[] A, int[] C, int n, int[] d) {
        int[] tmp = new int[d[0]+1];
        int index = 0;
        for (int s : d) {
            tmp[s] = index++;
        }
        int[] B = new int[d.length];
        while (n > 0) {
            B[tmp[A[n]]]++;
            n -= A[n];
        }
        return B;
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
                count++;
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
        printRes(flag, arr, d, 0);
        System.out.println("\nOptimal coin count: " + count);
    }
}
