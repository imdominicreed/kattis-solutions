import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ads {
    static boolean[][] visited;
    static char[][] grid;
    static HashSet<Character> legal = new HashSet<>(Arrays.asList('?', '!', ',', '.', ' '));
    public static boolean isLegal(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c) || legal.contains(c);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        visited = new boolean[n][m];
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == '+') {
                    var ar = find(i,j);
                    dfs(ar[0],ar[1],ar[2],ar[3]);
                }
            }
        }
        for(char[] s : grid) System.out.println(String.valueOf(s));
    }
    public static void del(int si, int ei, int sj, int ej) {
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                visited[i][j] = true;
                grid[i][j] = ' ';
            }
        }
    }
    public static int[] find(int si, int sj) {
        int endi = si;
        while (endi < grid.length && grid[endi][sj] == '+') endi++;
        endi--;
        int endj = sj;
        while (endj <  grid[si].length && grid[si][endj] == '+') endj++;
        endj--;
        return new int[]{si+1, endi-1, sj+1, endj-1};
    }
    public static void dfs(int si, int ei, int sj, int ej) {
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == '+') {
                    var ar = find(i,j);
                    dfs(ar[0],ar[1],ar[2],ar[3]);
                } else if(!isLegal(grid[i][j])) {
                    del(si-1, ei +1, sj -1, ej + 1);
                    return;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        for (int i = si-1; i <= ei+1; i++) {
            visited[i][sj-1] = true;
            visited[i][ej+1] = true;
        }
        for (int i = sj-1; i <= ej+1; i++) {
            visited[si-1][i] = true;
            visited[ei+1][i] = true;
        }
    }
}
