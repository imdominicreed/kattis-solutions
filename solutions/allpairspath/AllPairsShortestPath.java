import java.util.Arrays;
import java.util.Scanner;

public class AllPairsShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(solve(scanner));
    }
    static long big = 0x3f3f3f3f3f3f3f3L;
    static long inf = -0x3f3f3f3f3f3f3f3L;
    public static boolean solve(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        if(n == 0) return false;
        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], big);
            dp[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int src = scanner.nextInt();
            int dst = scanner.nextInt();
            long w = scanner.nextLong();
            dp[src][dst] = Math.min(dp[src][dst], w);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] == big || dp[k][j] == big) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[k][k] == 0 || dp[i][k] == big || dp[k][j] == big) continue;
                    dp[i][j] = inf;
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int ii = scanner.nextInt();
            int jj = scanner.nextInt();
            if(dp[ii][jj] == big) System.out.println("Impossible");
            else if(dp[ii][jj] == inf) System.out.println("-Infinity");
            else System.out.println(dp[ii][jj]);
        }
        System.out.println();
        return true;
    }
}
