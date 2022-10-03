import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AbstractPainting {
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

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            long answer = 3;
            for (int j = 0; j < columns; j++) {
                answer *= 6;
                answer %= 1000000007;
            }
            for (int j = 0; j < rows-1; j++) {
                answer *= 3;
                answer %= 1000000007;
                for (int k = 0; k < columns; k++) {
                    answer *= 2;
                    answer %= 1000000007;
                }
            }
            sb.append(answer);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
