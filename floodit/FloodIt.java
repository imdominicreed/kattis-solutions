import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class FloodIt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
    }
    static class Pair {
        int i;
        int j;
        Pair(int ii, int jj) {
            i = ii;
            j = jj;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i,j);
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return p.i == i && p.j == j;
        }
    }
    static Pair[][] set;
    static int[][] size;
    static Pair find(Pair x) {
        Pair p = set[x.i][x.j];
        if(x.i != p.i || x.j != p.j) set[x.i][x.j] = find(p);
        return set[x.i][x.j];
    }
    static void union(Pair a, Pair b) {
        var na = find(a);
        var nb = find(b);
        if (na.equals(nb)) return;
        if(na.i > nb.i || (na.i == nb.i && na.j > nb.j)) {
            var tmp = na;
            na = nb;
            nb = tmp;
        }
        set[nb.i][nb.j] = na;
        size[na.i][na.j] += size[nb.i][nb.j];
    }
    static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        char[][] g = new char[n][n];
        for (int i = 0; i < n; i++) {
            g[i] = scanner.next().toCharArray();
        }
        set = new Pair[n][n];
        size = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set[i][j] = new Pair(i,j);
                size[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != 0 && g[i-1][j] == g[i][j]) union(new Pair(i,j),new Pair(i-1,j));
                if(j != 0 && g[i][j-1] == g[i][j]) union(new Pair(i,j),new Pair(i,j-1));
            }
        }
        int moves = 0;
        int[] out = new int[6];
        while(true) {
            HashSet<Pair> sets = new HashSet<>();
            dfs(sets, new boolean[n][n], g, g[0][0], 0, 0);
            int[] all = new int[6];
            for (var p : sets) {
                var f = find(p);
                all[g[f.i][f.j] - '1'] += size[f.i][f.j];
            }
            int total = -1;
            int best = -1;
            for (int i = 0; i < 6; i++) {
                if (total < all[i]) {
                    best = i;
                    total = all[i];
                }
            }
            if (total == 0) break;
            out[best] += 1;
            moves++;
            dfs2(g, best, g[0][0], 0, 0);
        }
        System.out.println(moves);
        for (int i = 0; i < 6; i++) {
            System.out.print(out[i] + " ");
        }
    }
    static int[][] dirs = {{0,1}, {0,-1},{1,0}, {-1,0}};
    static void dfs2(char[][] g, int up, char num, int i, int j) {
        g[i][j] = (char) (up +'1');
        for (var d : dirs) {
            var ni = i + d[0];
            var nj = j + d[1];
            if (ni < 0 || ni >= g.length || nj < 0 || nj >= g[0].length) continue;
            if (g[ni][nj] == num) dfs2(g, up, num, ni,nj);
        }
    }
    public static void dfs(HashSet<Pair> sets, boolean[][] visited, char[][] g, char num, int i, int j) {
        if(visited[i][j]) return;
        visited[i][j] = true;
        for (var d : dirs) {
            var ni = i + d[0];
            var nj = j + d[1];
            if (ni < 0 || ni >= g.length || nj < 0 || nj >= g[0].length) continue;
            if (g[ni][nj] != num) sets.add(find(new Pair(ni, nj)));
            else dfs(sets, visited, g, num, ni, nj);
        }
    }
}
