import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HamiltooonianHike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] nodes = new ArrayList[n+1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            nodes[a].add(b);
            nodes[b].add(a);
        }
        ArrayList<Integer> next = new ArrayList<>();
        next.add(1);
        boolean[] visited = new boolean[n+1];
        int[] up = new int[n+1];
        Queue<Integer>[] down = new LinkedList[n+1];
        for (int i = 1; i < n+1; i++) {
            down[i] = new LinkedList<>();
        }
        visited[1] = true;
        while (!next.isEmpty()) {
            var curr = next;
            next = new ArrayList<>();
            for (var pop : curr) {
                for (var child : nodes[pop]) {
                    if (visited[child]) continue;
                    up[child] = pop;
                    down[pop].add(child);
                    visited[child] = true;
                    next.add(child);
                }
            }
        }
        visited = new boolean[n+1];
        int curr = 1;
        int d = 0;
        StringBuilder ret = new StringBuilder();
        visited[1] = true;
        ret.append(1);
        while (curr != 0) {
            if(!visited[curr] && (d == 3 || down[curr].isEmpty())) {
                visited[curr] = true;
                d = 0;
                ret.append(' ').append(curr);
            }
            curr = down[curr].isEmpty() ? up[curr] : down[curr].poll();
            d++;
        }
        System.out.println(ret.toString());
    }
}
