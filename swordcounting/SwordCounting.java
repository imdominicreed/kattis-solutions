
import java.util.HashSet;
import java.util.Scanner;

public class SwordCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer>[] nodes = new HashSet[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new HashSet<>();
        }
        int m = scanner.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            nodes[a].add(b);
            nodes[b].add(a);
            edges[i] = new int[]{a,b};
        }
        long ans = 0;
        for (var e : edges) {
            int a = e[0]; int b = e[1];
            var smaller = nodes[a].size() < nodes[b].size() ? nodes[a] : nodes[b];
            var bigger = nodes[a].size() >= nodes[b].size() ? nodes[a] : nodes[b];
            long bad = combo(bigger.size()-2);
            long good = combo(bigger.size()-1);
            int inter = 0;
            for(var child : smaller) {
                if (child == a || child == b) continue;
                if (!bigger.contains(child)) ans += good;
                else {
                    ans += bad;
                    inter++;
                }
            }
            ans += (combo(smaller.size()-1) * (bigger.size()-inter-1)) + (combo(smaller.size()-2) * inter);
        }
        System.out.println(ans);
    }
    public static long combo(int num) {
        if (num-2 <= 0) return 0;
        long sum = 1;
        for(int i = num-2; i <= num; i++) sum *= i;
        return sum/6;
    }
}
