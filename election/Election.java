import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Election {
    static long[][] combination;
    private static long getCombinations(int n, int r) {
        if (n == r || r == 0)
            return 1;
        if (combination[n][r] == -1)
            combination[n][r] = getCombinations(n - 1, r - 1) + getCombinations(n-1, r );
        return combination[n][r];
    }
    public static void main(String[] args) {
        combination = new long[51][51];
        for (long[] arr: combination) {
            Arrays.fill(arr, -1);
        }
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int unknown = n - (v1+v2);
            long w = scanner.nextInt();
            int majorityAmount = (n/2) + 1;
            if (v1 >= majorityAmount) {
                System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
                continue;
            }
            if (v2 >= (n + 1)/2) {
                System.out.println("RECOUNT!");
                continue;
            }
            int votesNeeded = majorityAmount-v1;
            long totalVotes = 1L << unknown;
            long votes = 0;
            for (int j = votesNeeded; j <= unknown; j++) {
                votes += getCombinations(unknown, j);
            }
            w *= totalVotes;
            votes *= 100;
            if (votes > w) {
                System.out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
            } else
                System.out.println("PATIENCE, EVERYONE!");
        }
    }
}
