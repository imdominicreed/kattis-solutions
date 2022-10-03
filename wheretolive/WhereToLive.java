import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhereToLive {
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
        int points = scanner.nextInt();
        while (points != 0) {
            float sumOfX = 0;
            float sumOfY = 0;
            for (int i = 0; i < points; i++) {
                 sumOfX += scanner.nextInt();
                 sumOfY += scanner.nextInt();
            }

            float centX = sumOfX / points;
            float centY = sumOfY / points;
            if (centX % 1 == 0.5) {
                centX = (float) Math.floor(centX);
            }
            if (centY % 1 == 0.5) {
                centY = (float) Math.floor(centY);
            }
            centX = Math.round(centX);
            centY = Math.round(centY);
            System.out.println((int) centX + " " + (int) centY);
            points = scanner.nextInt();
        }
    }
}
