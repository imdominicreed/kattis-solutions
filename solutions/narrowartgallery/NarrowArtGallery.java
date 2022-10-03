import java.util.Arrays;
import java.util.Scanner;

public class NarrowArtGallery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] dp0 = new int[n + 1][k + 1];
        int[][] dp1 = new int[n + 1][k + 1];
        for (int i = 0; i < dp0.length; i++) {
            Arrays.fill(dp0[i], (int) 1e9);
            Arrays.fill(dp1[i], (int) 1e9);
        }
        int total = 0;
        if (k != 0) {
            dp0[1][1] = scanner.nextInt();
            dp1[1][1] = scanner.nextInt();
            total = dp0[1][1] + dp1[1][1];
        } else {
            total += scanner.nextInt() + scanner.nextInt();
        }
        dp0[1][0] = 0;
        dp1[1][0] = 0;

        for (int i = 2; i < n + 1; i++) {
            int row1 = scanner.nextInt();
            total += row1;
            for (int j = 0; j < k + 1; j++) {
                int bestPrevious = Math.min(dp0[i - 1][j], dp1[i - 2][j]);
                dp0[i][j] = Math.min(dp0[i][j], bestPrevious);
                if (j != k)
                    dp0[i][j + 1] = bestPrevious + row1;
            }
            int row2 = scanner.nextInt();
            total += row2;
            for (int j = 0; j < k + 1; j++) {
                int bestPrevious = Math.min(dp1[i - 1][j], dp0[i - 2][j]);
                dp1[i][j] = Math.min(dp1[i][j], bestPrevious);
                if (j != k)
                    dp1[i][j + 1] = bestPrevious + row2;
            }
        }
        System.out.println(total - Math.min(dp0[n][k], dp1[n][k]));
    }
}
