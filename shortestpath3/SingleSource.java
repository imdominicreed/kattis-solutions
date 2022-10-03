import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SingleSource {
    static class Edge {
        int src;
        int dst;
        long w;

        Edge(int src, int dst, long w) {
            this.src = src;
            this.dst = dst;
            this.w = w;
        }
    }
    static long BIG = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if(!solve(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner))
                return;
        }
    }
    public static boolean solve(int n, int m, int q, int s, Scanner scanner) {
        if(n == 0 && m == 0 && q == 0 && s == 0) return false;
        var dist = new long[n];
        Arrays.fill(dist, BIG);
        dist[s] = 0;
        var edges = new Edge[m];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < n-1; i++) {
            for(var e : edges) {
                if(dist[e.src] == BIG) continue;
                dist[e.dst] = Math.min(dist[e.dst], dist[e.src] + e.w);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (var e : edges) {
                if(dist[e.src] == BIG) continue;
                if(dist[e.src] == (long) -1E12) dist[e.dst] = (long) -1E12;
                if(dist[e.dst] > dist[e.src] + e.w) {
                    dist[e.dst] = (long) -1E12;
                }
            }
        }
        while (q-- != 0) {
            int v = scanner.nextInt();
            if(dist[v]== BIG) System.out.println("Impossible");
            else if(dist[v] == (long) -1E12) System.out.println("-Infinity");
            else System.out.println(dist[v]);
        }
        return true;
    }
}
