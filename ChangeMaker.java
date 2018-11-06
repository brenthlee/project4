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
        int numCoins = scanner.nextInt();
        int[] denominations = new int[numCoins];
        for (int i = 0; i < numCoins; i++) {
            denominations[i] = scanner.nextInt();
        }
        do {
            System.out.println("Enter a positive amount to be change (entre 0 to quit):");
            int n = scanner.nextInt();
            if (n > 0) {
                int[] saved = change_DP(n, denominations);
            }
        } while (n > 0);
        System.out.println("Thanks for playing. Good Bye");
    }

    public static int[] change_DP(int n, int[] d) {
        int A[] = new int[];
        int C[] = new int[];
        for (i = 0; i < n; i++) {
        }
    }
}
