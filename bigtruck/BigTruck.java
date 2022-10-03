import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BigTruck {
    static int max = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pu = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            pu[i] = scanner.nextInt();
        }
        int[] dist = new int[n+1];
        int[] items = new int[n+1];
        Arrays.fill(dist, max);
        dist[1] = 0;
        items[1] = pu[1];
        int ed = scanner.nextInt();
        ArrayList<int[]> edges = new ArrayList<>();
        for(int i = 0; i < ed; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int d = scanner.nextInt();
            edges.add(new int[]{a,b,d});
            edges.add(new int[]{b,a,d});
        }
        for(int i = 0; i < n; i++) {
            for(var e : edges)
                dist[e[1]] = Math.min(dist[e[1]], dist[e[0]] + e[2]);
        }
        for (int i = 0; i < n; i++) {
            for(var e : edges)
                if(dist[e[0]] + e[2] == dist[e[1]]) items[e[1]] = Math.max(items[e[1]], items[e[0]] + pu[e[1]]);
        }
        if (dist[n] == max) System.out.println("impossible");
        else System.out.println(dist[n] + " " + items[n]);
    }
}
