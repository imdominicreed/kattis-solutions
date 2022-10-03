import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FullTank {
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

    static class Edge {
        int dest;
        int distance;

        Edge(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }

    static class City extends ArrayList<Edge> {
        int price;

        City(int price) {
            this.price = price;
        }
    }

    static class State implements Comparable<State> {
        int location;
        int fuel;
        int price;

        State(int location, int fuel, int price) {
            this.location = location;
            this.fuel = fuel;
            this.price = price;
        }

        @Override
        public int compareTo(State o) {
            return price - o.price;
        }
    }

    static City[] cities;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int city1 = scanner.nextInt();
            int city2 = scanner.nextInt();
            int distance = scanner.nextInt();
            cities[city1].add(new Edge(city2, distance));
            cities[city2].add(new Edge(city1, distance));
        }
        int q = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int bestPrice = djik(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            if (bestPrice == Integer.MAX_VALUE)
                sb.append("impossible");
            else
                sb.append(bestPrice);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static int djik(int c, int start, int end) {
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(start, 0, 0));
        int[][] distance = new int[cities.length][c + 1];
        for (int j = 0; j < distance.length; j++) {
            Arrays.fill(distance[j], Integer.MAX_VALUE);
        }
        while (!pq.isEmpty()) {
            State state = pq.poll();
            if (state.location == end)
                return state.price;
            if (state.price < distance[state.location][state.fuel]) {
                distance[state.location][state.fuel] = state.price;
                if (state.fuel != c && distance[state.location][state.fuel + 1] > state.price + cities[state.location].price)
                    pq.add(new State(state.location, state.fuel + 1, state.price + cities[state.location].price));
                for (Edge edge : cities[state.location]) {
                    if (state.fuel - edge.distance >= 0 && distance[edge.dest][state.fuel - edge.distance] > state.price)
                        pq.add(new State(edge.dest, state.fuel - edge.distance, state.price));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}