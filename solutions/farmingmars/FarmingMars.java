import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FarmingMars {
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
        int numAcres = scanner.nextInt();
        int numSets = scanner.nextInt();
        double[] phValues = new double[numAcres];
        for (int i = 0; i < phValues.length; i++) {
            phValues[i] = scanner.nextDouble();
        }
        for (int i = 0; i < numSets; i++) {
            int left = scanner.nextInt()-1;
            int right = scanner.nextInt()-1;
            int majority = ((right-left+1)/2)+1;
            int majIndex = left;
            int count = 1;
            for (int j = left+1; j < right+1; j++) {
                if (phValues[majIndex] == phValues[j])
                    count++;
                else
                    count--;
                if (count==0) {
                    majIndex = j;
                    count = 1;
                }
            }
            boolean passed = false;
            int counter =0;
            for (int j = left; j < right+1; j++) {

                if (phValues[j] == phValues[majIndex])
                    counter ++;
                if (majority<=counter) {
                    passed = true;
                    break;
                }
            }

            if (passed) {
                System.out.println("usable");
            } else {
                System.out.println("unusable");
            }
        }
    }
}
