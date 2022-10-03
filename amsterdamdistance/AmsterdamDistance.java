import java.util.PriorityQueue;
import java.util.Scanner;

public class AmsterdamDistance {
    static class Point implements Comparable<Point> {
        double w;
        int x;
        int y;
        Point(double w, int x, int y) {
            this.w = w;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            return Double.compare(w, point.w);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        double r = scanner.nextDouble();
        double vert = r/n;
        double[] hori = new double[n+1];
        double theta = 180D/m;
        hori[0] = 0D;
        double curr = vert;
        for (int i = 1; i <= n; i++) {
            hori[i] = Math.toRadians(theta) *  curr;
            curr += vert;
        }
        Point start = new Point(0, scanner.nextInt(), scanner.nextInt());
        Point end = new Point(0, scanner.nextInt(), scanner.nextInt());
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(start);
        boolean[][] visited = new boolean[m+1][n+1];
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(true) {
            var pop = pq.poll();
            if(pop.x == end.x && pop.y == end.y) {
                System.out.print(pop.w);
                return;
            }
            if(visited[pop.x][pop.y]) continue;
            visited[pop.x][pop.y] = true;
            for(var d : dirs) {
                double dw = 0;
                if(d[0] == 0) {
                    dw = vert;
                } else {
                    dw = hori[pop.y];
                }
                int x = pop.x + d[0];
                int y = pop.y + d[1];
                if(x < 0 || x > m || y < 0 || y > n) continue;
                pq.add(new Point(pop.w + dw, x, y));
            }
        }

    }
}
