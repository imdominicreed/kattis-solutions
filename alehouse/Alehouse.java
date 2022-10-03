import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Alehouse {
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

    static class Range implements Comparable<Range> {
        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range o) {
            if (start - o.start == 0)
                return end - o.end;
            return start - o.start;
        }
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = scanner.nextInt();
            R[i] = scanner.nextInt()+k;
        }
        Arrays.sort(L);
        Arrays.sort(R);
        int count = 0;
        int maxCount = 0;
        int lIn =0;
        int rIn = 0;
        for (int i = 0; i < 2*n; i++) {
            boolean decrease;
            if (lIn == n)
                decrease = true;
            else if (rIn == n)
                decrease = false;
            else decrease = L[lIn] > R[rIn];
            if (!decrease) {
                lIn++;
                count++;
            } else {
                rIn++;
                count--;
            }
            if (maxCount<count) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
    }
}
