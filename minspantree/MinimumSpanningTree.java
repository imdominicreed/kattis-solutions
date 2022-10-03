import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumSpanningTree {
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

    static class Edge implements Comparable<Edge> {
        int src;
        int dst;
        long weight;

        Edge(int src, int dst, int weight) {
            this.src = Math.min(src, dst);
            this.dst = Math.max(src, dst);
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(weight, o.weight);
        }

        @Override
        public String toString() {
            return src + " " + dst;
        }
    }

    static class UnionFind {
        private final int[] rank;
        private final int[] parent;
        private final int size;

        /**
         * Constructs a union find data stucture of a given size.
         *
         * @param size The given size.
         */
        UnionFind(final int size) {
            this.size = size;
            rank = new int[size];
            parent = new int[size];
            reset();
        }

        /**
         * Get the size if the union find data structure.
         *
         * @return The size if the union find data structure.
         */
        int getSize() {
            return size;
        }

        /**
         * Reset the union find data structure such that each node belongs to a
         * different set.
         */
        void reset() {
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        /**
         * Get the root of the requested node.
         *
         * @param x The requested node.
         * @return The root of the requested node.
         */
        int getRoot(final int x) {
            if (parent[x] != x) {
                parent[x] = getRoot(parent[x]);
            }
            return parent[x];
        }

        /**
         * Union the set that contains the 2 given node. Return true if successful and
         * return false if the 2 given nodes already belong to the same set.
         *
         * @param x The first given node.
         * @param y The second given node.
         * @return True if successful and false if the 2 given nodes already belong to
         *         the same set.
         */
        boolean union(final int x, final int y) {
            final int xRoot = getRoot(x);
            final int yRoot = getRoot(y);

            /* Return false if the 2 given nodes already belong to the same set. */
            if (xRoot == yRoot) {
                return false;
            }

            /*
             * If rank of xRoot is less than rank of yRoot, make xRoot's parent as yRoot.
             * Else if rank of yRoot is less than rank of xRoot, make yRoot's parent as
             * xRoot. Else, the rank of xRoot and yRoot are the same and make xRoot's parent
             * as yRoot and increase rank of yRoot.
             */
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        while (n != 0) {
            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int n1 = scanner.nextInt();
                int n2 = scanner.nextInt();
                edges.add(new Edge(n1, n2, scanner.nextInt()));
            }
            edges.sort(Comparator.naturalOrder());
            UnionFind set = new UnionFind(n);
            long dist = 0;
            ArrayList<Edge> mst = new ArrayList<>();
            for (Edge edge : edges) {
                if (set.union(edge.src, edge.dst)) {
                    mst.add(edge);
                    dist += edge.weight;
                }
            }
            mst.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    if (o1.src - o2.src == 0)
                        return o1.dst - o2.dst;
                    return o1.src - o2.src;
                }
            });
            if (mst.size() == n - 1) {
                System.out.println(dist);
                for (Edge edge : mst) {
                    System.out.println(edge);
                }
            } else
                System.out.println("Impossible");
            n = scanner.nextInt();
            m = scanner.nextInt();

        }
    }
}
