import java.util.Scanner;

public class KInaRow {
    public static void main(String[] args) {
        ans = new int[2];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
        System.out.println(ans[0] + ":" + ans[1]);
    }
    static int[][] dir = new int[][]{{0,-1}, {-1,0}, {-1,-1}, {-1,1}};
    static char[] c = new char[]{'x', 'o'};
    static int[] ans;
    public static void solve(Scanner scanner) {
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i <n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        int[][][][] dp = new int[4][n][m][2];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < 2; l++) {
                    if (grid[i][j] != c[l]) continue;
                    for (int o = 0; o < 4; o++) {
                        int num = 1;
                        int ni = i + dir[o][0];
                        int nj = j + dir[o][1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) num += dp[o][ni][nj][l];
                        dp[o][i][j][l] = num;
                        if(num >= k)  {
                            ans[l]++;
                            return;
                        }
                    }
                }
            }
        }
    }
}
