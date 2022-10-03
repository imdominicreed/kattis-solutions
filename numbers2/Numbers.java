import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.StringTokenizer;

public class Numbers {
     static class FastReader
         {
             BufferedReader br;
             StringTokenizer st;

             public FastReader()
             {
                 br = new BufferedReader(new
                         InputStreamReader(System.in));
             }

             String next()
             {
                 while (st == null || !st.hasMoreElements())
                 {
                     try
                     {
                         st = new StringTokenizer(br.readLine());
                     }
                     catch (IOException e)
                     {
                         e.printStackTrace();
                     }
                 }
                 return st.nextToken();
             }

             int nextInt()
             {
                 return Integer.parseInt(next());
             }

             long nextLong()
             {
                 return Long.parseLong(next());
             }

             double nextDouble()
             {
                 return Double.parseDouble(next());
             }

             String nextLine()
             {
                 String str = "";
                 try
                 {
                     str = br.readLine();
                 }
                 catch (IOException e)
                 {
                     e.printStackTrace();
                 }
                 return str;
             }
         }
    static double pow(double num, int pow) {
         double ans = 1;
        for (int i = 0; i < pow; i++) {
            if (Math.log10(ans) > 5) {
                ans %= 1000;
            }
            ans *= num;
        }
        return ans;
    }

    static long dp[];
    public static void main(String[] args) {
        dp = new long[100];
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        dp[0] = 2;
        dp[1] = 6;
        for (int i = 2; i < 102; i++) {
            dp[i% 100] = (6 * dp[(i - 1) % 100] + 1000000) - (4 * dp[i - 2] % 1000);
            dp[i%100] %= 1000;
        }
        for (int i = 0; i < n; i++) {
            sb.append("Case #");
            sb.append(i + 1);
            sb.append(": ");
            StringBuilder num = new StringBuilder();
            long curretNum = dp[ (scanner.nextInt() % 100)] - 1;
            for (int j = 0; j < 3; j++) {
                num.append(curretNum %10);
                curretNum /= 10;
            }
            sb.append(num.reverse());
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}

