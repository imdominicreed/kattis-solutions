import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivideBY100 {
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
        char[] nums = scanner.next().toCharArray();
        int numDec = scanner.next().length() - 1;
        boolean deleteZeros = true;
        StringBuilder string = new StringBuilder();
        for (int i = nums.length - 1; i > -1; i--) {
            if (i == nums.length - numDec - 1) {
                if (string.length() != 0)
                    string.append('.');
                deleteZeros = false;
            }
            if (deleteZeros) {
                if (nums[i] != '0') {
                    deleteZeros = false;
                    string.append(nums[i]);
                }
            } else {
                string.append(nums[i]);
            }
        }
        for (int i = 0; i < numDec-nums.length; i++) {
            string.append('0');
        }
        if (numDec+1>nums.length) {
            string.append(".0");
        }
        System.out.println(string.reverse().toString());
    }
}
