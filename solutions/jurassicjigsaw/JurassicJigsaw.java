import java.util.*;

public class JurassicJigsaw {
    static int compare(String string1, String string2) {
        int diff = 0;
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i))
                diff++;
        }
        return diff;
    }
    static class Pair implements Comparable<Pair> {
        int weight;
        int src;
        int index;
        Pair(int weight, int src, int index)
        {
            this.weight = weight;
            this.src = src;
            this.index =index;
        }
        @Override
        public int compareTo(Pair o) {
            return weight-o.weight;
        }
    }

    static boolean[] taken;
    static void process(int vertex, PriorityQueue<Pair> pq) {
        int total = 0;
        for (int i = 0; i < adjMatrix[vertex].length; i++) {
            if (!taken[i])
                pq.add(new Pair(adjMatrix[vertex][i], vertex, i));
        }
    }
    static int[][] adjMatrix;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int length = scanner.nextInt();
        adjMatrix = new int[n][n];
        String[] strings = new String[n];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = compare(strings[i], strings[j]);
            }
        }
        int total = 0;
        StringBuilder sb = new StringBuilder();
        taken = new boolean[n];
        taken[0] = true;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        process(0, pq);
        while(!pq.isEmpty()) {
            Pair bestEdge = pq.poll();
            if (!taken[bestEdge.index]) {
                taken[bestEdge.index] = true;
                sb.append(bestEdge.src);
                sb.append(' ');
                sb.append(bestEdge.index);
                sb.append('\n');
                total += bestEdge.weight;
                process(bestEdge.index,pq);
            }
        }
        System.out.println(total);
        System.out.println(sb.toString());

    }
}
