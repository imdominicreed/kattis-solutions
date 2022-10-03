import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Hoppers {
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

    static class Graph {
        static class Vertex extends ArrayList<Integer> {
            int rank;
            Boolean color;

            Vertex(int rank) {
                this.rank = rank;
            }
        }

        Vertex[] vertices;

        Graph(int v) {
            vertices = new Vertex[v];
            for (int i = 0; i < v; i++) {
                vertices[i] = new Vertex(i);
            }
        }

        void connect(int comp1, int comp2) {
            vertices[comp1].add(comp2);
            vertices[comp2].add(comp1);
        }

        static int size;

        void isBipartite(int i, boolean[] color) {
            for (int child : vertices[i]) {
                for (int rec : vertices[child]) {
                    if (!color[rec]) {
                        color[rec] = true;
                        size++;
                        isBipartite(rec, color);
                    }
                }
            }
        }

        void getSubGraphs(int node, List<Integer> list, boolean[] visited) {
            list.add(node);
            visited[node] = true;
            for (int children : vertices[node]) {
                if (!visited[children]) {
                    getSubGraphs(children, list, visited);
                }
            }
        }

        void solve() {
            List<List<Integer>> comps = new ArrayList<>();
            boolean[] visited = new boolean[vertices.length];
            for (int i = 0; i < vertices.length; i++) {
                if (!visited[i]) {
                    List<Integer> hold = new ArrayList<>();
                    getSubGraphs(i, hold, visited);
                    comps.add(hold);
                }
            }
            int ans = comps.size() - 1;
            boolean b = false;
            boolean[] color = new boolean[vertices.length];
            for (List<Integer> comp : comps) {
                size = 0;
                isBipartite(comp.get(0), color);
                b = size == comp.size();
                if (b)
                    break;
            }
            System.out.println(b ? ans : ans+1);
        }
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            graph.connect(scanner.nextInt() - 1, scanner.nextInt() - 1);
        }
        graph.solve();
    }
}
