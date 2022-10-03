import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;

public class WordCloud {
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
                     catch (IOException  e)
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
        int W = scanner.nextInt();
        int N = scanner.nextInt();
        int counter = 1;
        while(W != 0 && N != 0) {
            Vector<Word> list = new Vector<>();
            int max =-1;
            for (int i = 0; i < N; i++) {
                int length = scanner.next().length();
                int num = scanner.nextInt();
                max = Math.max(num,max);
                list.add(new Word(length, num));
            }
            pairInts[] words = new pairInts[N];
            for (int i = 0; i < N; i++) {
                int P = 8+ (int) Math.ceil((40*(list.get(i).occurence-4))/(float)(max-4));
                words[i] = new pairInts(P, (int) Math.ceil((float) 9 / 16 * list.get(i).length * P));
            }
            boolean nextRow = true;
            int currentWidth = 0;
            int height = 0;
            int currentHeight = 0;
            for (int i = 0; i < words.length; i++) {
                if (nextRow) {
                    height += currentHeight;
                    nextRow = false;
                    currentWidth = words[i].width;
                    currentHeight = words[i].height;
                    continue;
                }
                if (currentWidth+words[i].width+10 <= W) {
                    currentWidth += words[i].width+10;
                    currentHeight = Math.max(words[i].height, currentHeight);
                } else {
                    nextRow = true;
                    i--;
                }
            }
            if (!nextRow) {
                height+= currentHeight;
            }

            System.out.println("CLOUD " + counter + ": "+ height);
            W = scanner.nextInt();
            N = scanner.nextInt();
            counter++;
        }
    }
    static class pairInts{
         int height;
         int width;
         pairInts(int height, int width) {
             this.height = height;
             this.width = width;
         }



    }
    static class Word  {
         int length;
         int occurence;
         Word(int length, int occurence) {
             this.length = length;
             this.occurence = occurence;
         }

    }

}
