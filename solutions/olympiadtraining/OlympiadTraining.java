import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class OlympiadTraining {
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
    static class Student {
        int id;
        int[] points;
        Student(int id, int size) {
            this.id = id;
            points = new int[size];
        }
    }


    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int cases = scanner.nextInt();
        while (cases != 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            Student[] students = new Student[n];
            long[] dp = new long[1 << n];
            for (int i = 0; i < n; i++) {
                students[i] = new Student(i, m);
                for (int j = 0; j < m; j++) {
                    students[i].points[j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                int finalI = i;
                Arrays.sort(students, (o1, o2) -> Long.compare(o2.points[finalI], o1.points[finalI]));
                int mask = (1 << n) -1;
                for (int j = 0; j < n; j++) {
                    dp[mask] += students[j].points[i];
                    mask ^= 1 << students[j].id;
                    dp[mask] -= students[j].points[i];
                }
            }
            for (int i = 0; i < n; i++) {
                int mask = 1<<i;
                for (int j = (1<<n) -1; j > 0 ; j--) {
                    if ((mask & j) == 0) {
                        dp[j] += dp[mask | j];
                    }
                }
            }
            long ans[] = new long[n+1];
            Arrays.fill(ans, Long.MAX_VALUE);
            for (int i = 0; i < 1<<n; i++) {
                ans[Integer.bitCount(i)] = Math.min(ans[Integer.bitCount(i)], dp[i]);
            }
            for (int i = 0; i < q; i++) {
                System.out.println(ans[scanner.nextInt()]);
            }
            cases--;
        }
    }
}
