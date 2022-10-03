import java.util.Arrays;
import java.util.Scanner;

public class Spiderman {
    static int[][] dp;
    static int[] numbers;

    public static void getMin() {
        for (int index = 0; index < numbers.length; index++) {
            for (int height = 0; height < dp[index].length; height++) {
                if (dp[index][height] != Integer.MAX_VALUE) {
                    //calculate up
                    int number = height + numbers[index];
                    dp[index + 1][number] = Math.min(dp[index + 1][number], Math.max(dp[index][height], number));
                    //calculate down
                    number = height - numbers[index];
                    if (number >= 0) {
                        dp[index + 1][number] = Math.min(dp[index + 1][number], Math.max(dp[index][height], number));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int b = 0; b < cases; b++) {
            numbers = new int[scanner.nextInt()];
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                int num = scanner.nextInt();
                numbers[i] = num;
                sum += num;
            }
            dp = new int[numbers.length + 1][sum + 2];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][0] = 0;
            getMin();
            if (dp[dp.length - 1][0] == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                int number = 0;
                StringBuilder sb = new StringBuilder();
                for (int row = numbers.length - 1; row > 0; row--) {
                    int upCol = number + numbers[row];
                    int downCol = number - numbers[row];
                    int downHeight = Integer.MAX_VALUE;
                    if (downCol >= 0) {
                        downHeight = dp[row][downCol];
                    }
                    int upHeight = dp[row][upCol];
                    if (downHeight > upHeight) {
                        sb.append('D');
                        number = upCol;
                    } else {
                        sb.append('U');
                        number = downCol;
                    }
                }
                sb.append('U');
                System.out.println(sb.reverse().toString());
            }
        }
    }
}
