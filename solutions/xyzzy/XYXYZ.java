import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class XYXYZ {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        while(solve(scanner));
    }
    static class Edge {
        int src;
        int dest;
        int w;
        Edge(int src, int dest, int ww) {
            this.src = src;
            this.dest = dest;
            this.w =ww;
        }
    }
    static int SMALL = (int) -1E7;
    static int BIG = (int) 1E7;
    public static boolean solve(FastReader scanner) {
        int n = scanner.nextInt();
        if(n==-1) return false;
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int c = scanner.nextInt();
            for(int j = 0 ; j < c; j++) {
                edges.add(new Edge(i, scanner.nextInt()-1, w));
            }
        }
        int[] distance = new int[n];
        Arrays.fill(distance, SMALL);
        distance[0] = 100;
        for(int i = 0; i < n-1 ;i ++) {
            for(Edge e : edges) {
                if(distance[e.src] + e.w > 0)
                    distance[e.dest] = Math.max(distance[e.dest], distance[e.src] + e.w);
            }
        }
        for(int i = 0; i < n-1; i++) {
            for(Edge e: edges) {
                if(distance[e.src] + e.w > 0 && distance[e.src] + e.w > distance[e.dest]) distance[e.dest] = BIG;
            }
        }
        if(distance[n-1] >= 0) System.out.println("winnable");
        else System.out.println("hopeless");
        return true;
    }
    
}
