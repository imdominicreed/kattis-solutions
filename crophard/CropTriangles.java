import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CropTriangles {
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
        int cases = scanner.nextInt();
        for (int a = 0; a < cases; a++) {
            int N = scanner.nextInt();
            long[][] mods = new long[3][3];
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            int D = scanner.nextInt();
            int X0 = scanner.nextInt();
            int Y0 = scanner.nextInt();
            int M = scanner.nextInt();
            mods[X0 % 3][Y0 % 3]++;
            long X = X0;
            long Y = Y0;
            long answer = 0;
            for (int i = 1; i < N; i++) {
                X = ((B + (long) A * X) % M);
                Y = ((D + (long) C * Y) % M);
                int XI = (int) (X % 3);
                int YI = (int) (Y % 3);
                mods[XI][YI]++;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    long trees = mods[i][j];
                    answer += (trees * (trees - 1) * (trees - 2)) / 6;
                }
            }
            for (int i = 0; i < 9; i++) {
                for (int j = i + 1; j < 9; j++) {
                    for (int k = j+1; k < 9; k++) {
                        if ((i/3+j/3+k/3) %3 == 0 && (i%3 + j%3 +k%3)%3 == 0)
                            answer += mods[i / 3][i % 3] * mods[j / 3][j % 3] * mods[k / 3][k % 3];
                    }
                }
            }
            System.out.println("Case " + "#" + (a + 1) + ": " + answer);
        }
    }
}
