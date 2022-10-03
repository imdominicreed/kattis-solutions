import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightSearch {
    static class Node{
        int i, j, p;

        public Node(int i, int j, int p) {
            this.i = i;
            this.j = j;
            this.p = p;
        }
    }
    public static void main(String[] args) {
        String find = "ICPCASIASG";
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String line = scanner.next();
        char[][] grid = new char[n][n];
        boolean[][][] visited = new boolean[n][n][find.length()];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt((i*n) + j);
                if(grid[i][j] == 'I') {
                    visited[i][j][0] = true;
                    q.add(new Node(i,j,0));
                }
            }
        }

        while (!q.isEmpty()) {
            var p = q.poll();
            int r = p.i;
            int c = p.j;
            int[][] legalMoves = {{r + 2, c + 1}, {r + 2, c - 1}, {r - 2, c - 1}, {r - 2, c + 1}, {r + 1, c + 2}, {r + 1, c - 2}, {r - 1, c + 2}, {r - 1, c - 2}};
            for(var move : legalMoves) {
                int i = move[0]; int j = move[1]; int np = p.p+1;
                if(i < 0 || i >= n || j < 0 || j >= n || np >= find.length() || find.charAt(np) != grid[i][j] || visited[i][j][np]) continue;
                visited[i][j][np] = true;
                if(np == find.length()-1) {
                    System.out.println("YES");
                    return;
                }
                q.add(new Node(i,j,np));
            }
        }
        System.out.println("NO");
    }
}
