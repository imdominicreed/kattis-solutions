import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Invasion {
    static class Town {
        ArrayList<Edge> edges;
        Town() {
            edges = new ArrayList<>();
        }
    }
    static class Edge implements Comparable<Edge> {
        int dst;
        int distance;
        Edge(int dst, int distance) {
            this.dst = dst;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return distance - o.distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int a = Integer.parseInt(line[2]);
        int k = Integer.parseInt(line[3]);
        StringBuilder sb = new StringBuilder();
        while (n != 0 || m != 0 || a != 0 || k != 0) {
            int ans = n;
            Town[] towns = new Town[n];
            for (int i = 0; i < towns.length; i++) {
                towns[i] = new Town();
            }
            for (int i = 0; i < m; i++) {
                String line1[] = br.readLine().split(" ");
                int first = Integer.parseInt(line1[0])-1;
                int second = Integer.parseInt(line1[1])-1;
                int distance = Integer.parseInt(line1[2]);
                towns[first].edges.add(new Edge(second, distance));
                towns[second].edges.add(new Edge(first, distance));
            }
            int distances[] = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < a; i++) {
                String line2 = br.readLine();
                int ind = Integer.parseInt(line2)-1;
                pq.add(new Edge(ind, 0));
                while (!pq.isEmpty()) {
                    Edge edge = pq.poll();
                    if (distances[edge.dst] == Integer.MAX_VALUE)
                        ans--;
                    if (edge.distance>=distances[edge.dst])
                        continue;
                    distances[edge.dst] = edge.distance;
                    for (Edge children : towns[edge.dst].edges) {
                        if (children.distance + distances[edge.dst] >= k)
                            continue;
                        pq.add(new Edge(children.dst, children.distance + distances[edge.dst]));
                    }
                }
                sb.append(ans).append('\n');
            }

            sb.append('\n');
            line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            a = Integer.parseInt(line[2]);
            k = Integer.parseInt(line[3]);
        }
        System.out.print(sb.toString());
    }
}
