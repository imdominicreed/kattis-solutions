import java.util.Scanner;

public class FallingApples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        for(int j = 0; j < m; j++) {
            int p = n-1;
            for(int i = n-1; i >= 0; i--) {
                if (grid[i][j] == 'a') {
                    grid[i][j] = '.';
                    grid[p--][j] = 'a';
                }
                if (grid[i][j] == '#')  p = i-1;
            }
        }
        for(var s : grid) System.out.println(String.valueOf(s));
    }
}
