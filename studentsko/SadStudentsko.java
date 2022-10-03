import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SadStudentsko {
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

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            students[i] = num;
        }
        int[] ordered = students.clone();
        Arrays.sort(ordered);
        HashMap<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < ordered.length; i++) {
            index.put(ordered[i], (i / K) + 1);
        }
        int[] normalized = new int[N];
        for (int i = 0; i < N; i++) {
            normalized[i] = index.get(students[i]);
        }
       /* int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (normalized[j] >= normalized[i]) {
                    dp[i] += dp[j];
                }
            }

        }
        int answer = -1;
        for (int value : dp) {
            answer = Math.max(answer, value);
        } */
        System.out.println(N - lengthOfLIS(normalized));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] <= x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
