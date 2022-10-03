import java.util.PriorityQueue;
import java.util.Scanner;

class CrossCountry {
    static class Pair {
        int d;
        int i;
        Pair(int ii, int dd) {
            i = ii;
            d = dd;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.d-o2.d);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int t= scanner.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        if( s== t) {
            System.out.println(0);
            return;
        }
        pq.add(new Pair(s,0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()) {
            var pop = pq.poll();
            if(visited[pop.i]) continue;
            visited[pop.i] = true;
            if(t == pop.i) {
                System.out.println(pop.d);
                return;
            }
            for(int i = 0; i < n; i++) {
                pq.add(new Pair(i, pop.d+grid[pop.i][i]));
            }
        }
    }
}