import java.util.PriorityQueue;
import java.util.Scanner;

public class EmptyingTheBaltic {
    static class Location implements Comparable<Location>{
        int i;
        int j;
        int weight;
        Location(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }

        @Override
        public int compareTo(Location o) {
            return  o.weight-weight;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[][] grid = new int[h][w];
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = -1*scanner.nextInt();
                if (grid[i][j] <= 0)
                    visited[i][j] = true;
            }
        }
        PriorityQueue<Location> pq = new PriorityQueue<>();
        int drainI = scanner.nextInt()-1;
        int drainJ = scanner.nextInt()-1;
        pq.add(new Location(drainI, drainJ, grid[drainI][drainJ]));
        int[][] moves = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        long answer = 0;
        while (!pq.isEmpty()) {
            Location location = pq.poll();
            if (!visited[location.i][location.j]) {
                grid[location.i][location.j] = Math.min(grid[location.i][location.j], location.weight);
                answer += grid[location.i][location.j];
                visited[location.i][location.j] = true;
                for(int[] move : moves) {
                    if (h != move[0] + location.i && -1 != move[0] + location.i && move[1] + location.j != w && move[1] + location.j != -1 && !visited[location.i + move[0]][location.j + move[1]]) {
                        pq.add(new Location(location.i + move[0], location.j + move[1], grid[location.i][location.j]));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
