import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Supercomputer {
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
    static class FenwickTree {
         int[] values;
         int[] tree;
         FenwickTree(int length) {
             values = new int[length];
             tree = new int[length+1];
         }
         public void set(int index) {
             int value = 1 == values[index] ? 0 : 1;
             int dif = value - values[index];
             values[index] = value;
             index++;
             while (index<tree.length) {
                 tree[index] += dif;
                 index += index & (-1 * index);
             }
         }
         public int getSum(int index) {
             int sum = 0;
             while(index>0) {
                 sum += tree[index];
                 index -= index & (-1 * index);
             }
             return sum;
         }
    }
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        FenwickTree tree = new FenwickTree(N);
        for (int i = 0; i < K; i++) {
            String op = scanner.next();
            if (op.equals("F")) {
                tree.set(scanner.nextInt()-1);
            } else {
                System.out.println(-tree.getSum(scanner.nextInt()-1) + tree.getSum(scanner.nextInt()));
            }
        }
    }
}
