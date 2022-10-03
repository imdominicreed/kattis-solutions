import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class CodeCleanups {
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
        int dirtyPush = 0;
        int cleanUpPhases = 0;
        int[] days = new int[cases];
        for (int i = 0; i < days.length; i++) {
            days[i] = scanner.nextInt();
        }
        Vector<Integer> stillDirty = new Vector<>();
        for (int i = 0; i < cases; i++) {
            dirtyPush = days[i];
            int dirtiness = 0;
            for (int dirtyDays : stillDirty) {
                dirtiness += dirtyPush-dirtyDays;
            }
            if (dirtiness>=20) {
                stillDirty.clear();
                cleanUpPhases++;
            }
            stillDirty.add(dirtyPush);
        }
        System.out.println(cleanUpPhases+1);
    }

}
