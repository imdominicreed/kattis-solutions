import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RainbowRoadRace2 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Node implements Comparable<Node> {
        int val;
        int set;
        int id;

        Node(int val, int set, int id) {
            this.val = val;
            this.set = set;
            this.id = id;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }
    static class Child {
        int color;
        int val;
        int dst;
        Child(int color, int val, int dst) {
            this.color = color;
            this.val = val;
            this.dst = dst;
        }
    }
    static int getMask(char letter) {
        switch (letter) {
            case 'R':
                return 1;
            case 'O':
                return 2;
            case 'Y':
                return 4;
            case 'G':
                return 8;
            case 'B':
                return 16;
            case 'I':
                return 32;
            default:
                return 64;
        }
    }
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Child>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int src = scanner.nextInt()-1;
            int dst = scanner.nextInt()-1;
            int val = scanner.nextInt();
            int color = getMask(scanner.next().charAt(0));
            nodes[src].add(new Child(color, val, dst));
            nodes[dst].add(new Child(color, val, src));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        boolean[][] visited = new boolean[128][n];
        while (!pq.isEmpty()) {
            Node pop = pq.poll();
            if (pop.id == 0 && pop.set == 127) {
                System.out.println(pop.val);
                return;
            }
            if (visited[pop.set][pop.id])
                continue;
            visited[pop.set][pop.id] = true;
            for (Child child : nodes[pop.id]) {
                int color = child.color | pop.set;
                int dst = child.dst;
                int val = child.val + pop.val;
                if (visited[color][dst])
                    continue;
                pq.add(new Node(val, color, dst));
            }
        }
    }
}
