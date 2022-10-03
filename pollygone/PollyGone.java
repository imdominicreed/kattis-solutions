import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PollyGone {
    final static int maxDec = 10000;
    static class Box {
        int e;
        int p;
        Box(int e, int p) {
            this.e = e;
            this.p = p;
        }
    }
    final static int big = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextBigDecimal().multiply(BigDecimal.valueOf(maxDec)).intValue();
        Box[] boxes = new Box[n];
        for(int i = 0; i < n; i ++){
            boxes[i] = new Box(scanner.nextInt(), scanner.nextBigDecimal().multiply(BigDecimal.valueOf(maxDec)).intValue());
        }
        int[][] dp = new int[n+1][2*maxDec];
        for(int[] d : dp) Arrays.fill(d, big);
        int best = big;
        dp[0][0] = 0;
        dp[0][boxes[0].p] = boxes[0].e;
        if(boxes[0].p >=p) best = boxes[0].e;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxDec; j++) {
                int b = Math.min(dp[i][j], dp[i - 1][j]);
                int add = big;
                if (boxes[i].p <= j)
                    add = dp[i - 1][j - boxes[i].p] + boxes[i].e;
                dp[i][j] = Math.min(b, add);
                if (j >= p) best = Math.min(best, dp[i][j]);
            }
        }
        System.out.println(best);
    }
}
