import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DistinctiveCharacter {
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

        int nextInt(int base) {
            return Integer.parseInt(next(), base);
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

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt(10);
        int k = scanner.nextInt(10);
        int[] seen = new int[1 << k];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(seen, -1);
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt(2);
            queue.add(num);
            seen[num] = 0;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (seen[curr] == -1) {
                seen[curr]++;
            }
            int mask = 1;
            for (int i = 0; i < k; i++) {
                int num = curr ^ mask;
                if (seen[num] == -1) {
                    seen[num] = seen[curr] + 1;
                    queue.add(num);
                }
                mask <<= 1;
            }
        }
        for (int i = 0; i < seen.length; i++) {
            ans = seen[i] > seen[ans] ? i : ans;
        }
        StringBuilder sb = new StringBuilder();
        int mask = 1;
        for (int i = 0; i < k; i++) {
            if ((mask & ans) != 0)
                sb.append(1);
            else
                sb.append(0);
            mask <<= 1;
        }
        System.out.println(sb.reverse().toString());
    }
}
