import java.util.Scanner;

public class ConstrainedFreedomofChoice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        while(n != 0 && m != 0) {
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = scanner.next().toCharArray();
            }
            solve(grid, n,m);
            n = scanner.nextInt();
            m = scanner.nextInt();
        }
    }
    public static void solve(char[][] grid, int n, int m) {
        int[][] dp = new int[n][m];
        int curr = n -1 ;
        while(curr >= 0 && grid[curr][0] != '#') {
            dp[curr][0] = 1;
            curr--;
        }
        for(int i = 1; i < m; i++) {
            int[] col = new int[n];
            for(int j = 0; j < n; j++) {
                if(grid[j][i] == '#') continue;
                col[j] = dp[j][i-1];
            }
            int start = 0;
            while(start < n) {
                int sum = 0;
                int end = start;
                while(end < n && grid[end][i] != '#') {
                    sum += col[end];
                    end++;
                }
                for(int j = start; j < end; j++) {
                    dp[j][i] = sum;
                }
                start = end+1;
            }
        }
        System.out.println(dp[0][m-1]);
    }
}
