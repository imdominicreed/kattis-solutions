import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FractionalLotion {
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

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        int[] cache = new int[10001];
        Arrays.fill(cache, -1);
        String line;
        while ((line = scanner.nextLine()) != null) {
            int n = Integer.parseInt(line.substring(2));
            bw.write(String.valueOf(solve(n)) + '\n');
        }
        bw.flush();
    }

    public static int solve(int n) {
        int ans = 0;
        for (int i = n + 1; i < (n<<1) + 1; i++) {
            if ((n*i) % (i-n) == 0)
                ans++;
        }
        return ans;
    }
}