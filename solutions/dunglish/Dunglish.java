import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Dunglish {
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
        int numWords = scanner. nextInt();
        HashMap<String, Integer> wordsInSentence = new HashMap<>();
        String text = scanner.nextLine();
        String[] words = text.split(" ");
        for (String word : words) {
            wordsInSentence.putIfAbsent(word, 0);
            wordsInSentence.put(word, wordsInSentence.get(word) + 1);
        }
        int dic = scanner.nextInt();
        HashMap<String, String> dict = new HashMap<>();
        HashMap<String, Integer> correct = new HashMap<>();
        HashMap<String, Integer> incorrect = new HashMap<>();
        for (int i = 0; i <  dic; i++) {
            String word = scanner.next();
            String trans = scanner.next();
            String cor = scanner.next();
            dict.putIfAbsent(word, trans);
            if ("correct".equals(cor)) {
                dict.put(word, trans);
                incorrect.putIfAbsent(word, 0);
                correct.putIfAbsent(word, 0);
                correct.put(word, correct.get(word)+1);
            } else {
                correct.putIfAbsent(word, 0);
                incorrect.putIfAbsent(word, 0);
                incorrect.put(word, incorrect.get(word)+1);
            }
        }
        StringBuilder ans = new StringBuilder();
        long total = 1;
        long corr = 1;
        for (String word: words) {
            ans.append(dict.get(word));
            ans.append(" ");
            total *= (correct.get(word) + incorrect.get(word));
            corr *= correct.get(word);
        }
        if (corr == 1) {
            System.out.println(ans.toString());
            System.out.println("correct");
        } else if(total-corr == 1) {
            System.out.println(ans.toString());
            System.out.println("incorrect");
        } else {
            System.out.println(corr + " correct");
            System.out.println(total - corr + " incorrect");
        }

    }
}
