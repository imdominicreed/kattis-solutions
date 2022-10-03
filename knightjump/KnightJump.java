import java.util.*;

public class KnightJump {

    static boolean[][] legal;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int row = -1;
        int column = -1;
        legal = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == '.') {
                    legal[i][j] = false;
                } else if (line.charAt(j) == 'K') {
                    legal[i][j] = false;
                    row = i;
                    column = j;
                } else {
                    legal[i][j] = true;
                }
            }
        }
        System.out.println(BFS(legal, new int[]{row, column, 0}));
    }

    public static long BFS(boolean[][] visited, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int counter = 0;
        while (!queue.isEmpty()) {
            int[] x = queue.remove();
            if (x[0] == 0 && x[1] == 0) {
                return x[2];
            }
            if (x[0] < 0 || x[0] >= visited.length || x[1] < 0 || x[1] >= visited.length || visited[x[0]][x[1]]) {
                continue;
            }
            visited[x[0]][x[1]] = true;
            int r = x[0];
            int c = x[1];
            int[][] legalMoves = {{r + 2, c + 1}, {r + 2, c - 1}, {r - 2, c - 1}, {r - 2, c + 1}, {r + 1, c + 2}, {r + 1, c - 2}, {r - 1, c + 2}, {r - 1, c - 2}};
            for (int[] move : legalMoves) {
                queue.add(new int[]{move[0], move[1], x[2] + 1});
            }
        }
        return -1;
    }
}
