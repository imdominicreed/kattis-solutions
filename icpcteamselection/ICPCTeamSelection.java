import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ICPCTeamSelection {
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
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int sum = 0;
            int n = scanner.nextInt();
            int[] students = new int[3*n];
            for (int j = 0; j < 3*n; j++) {
                students[j] = scanner.nextInt();
            }
            Arrays.sort(students);
            int lb = 0; int rb = students.length-2;
            while (lb < rb) {
                sum += students[rb];
                rb -=2;
                lb++;
            }
            System.out.println(sum);
        }
    }
}
