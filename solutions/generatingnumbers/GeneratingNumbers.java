import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class GeneratingNumbers {
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
        StringBuilder ans = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            ans.append(getNumInstructions(scanner.nextInt()));
            ans.append('\n');
        }
        System.out.println(ans.toString());
    }

    public static int getNumInstructions(int num) {
        int numDigits = (int) (Math.log10(num));
        int numInstructions = 0;
        int curr = 1;
        if (num < 10) {
            return num - 1;
        }
        boolean divisible = num % Math.pow(10, numDigits) == 0;
        for (int i = 0; i < numDigits; i++) {
            numInstructions += calculateToNextTens(curr);
            curr *= 10;
        }
        if (curr == num)
            return numInstructions;

        if (divisible)
            num--;
        Integer[] digits = new Integer[numDigits + 1];
        boolean fixedOne = false;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        //this is slightly inefficient but couldnt get the brains to solve it xD
        if (digits[numDigits] == 1) {
            digits[numDigits] = 0;
            fixedOne = true;
        } else {
            for (int i = numDigits; i > -1; i--) {
                if (digits[i] == 1) {
                    digits[i] = 0;
                    fixedOne = true;
                    break;
                }
            }
        }
        if (digits[0] == 0) {
            Arrays.sort(digits, Collections.reverseOrder());
            numInstructions++;
        }
        while (digits[0] != 0) {
            numInstructions += (fixedOne) ? digits[0] + 1 : digits[0];
            fixedOne = true;
            digits[0] = 0;
            Arrays.sort(digits, Collections.reverseOrder());
        }
        return numInstructions - 1 + (divisible ? 1 : 0);
    }

    public static int calculateToNextTens(int x) {
        int numInstructions = 0;
        int[] digits = new int[(int) (Math.log10(x) + 1)];
        int temp = x;
        for (int i = digits.length - 1; i > -1; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        if (digits[0] == 9) {
            Arrays.sort(digits);
            numInstructions++;
        }
        while (digits[0] != 9) {
            numInstructions += 9 - digits[0];
            numInstructions++;
            digits[0] = 9;
            Arrays.sort(digits);
        }
        return numInstructions;
    }
}
