import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PeriodicStrings {
    static boolean isPermutation(char[] str1, char[] str2, int startingIndex) {
        startingIndex = str1.length-(startingIndex%str1.length);
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[(startingIndex+i) % str1.length])
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (int i = 1; i < line.length()+1; i++) {
            if (line.length() % i != 0)
                continue;
            char[] currentVariation = line.substring(0, i).toCharArray();
            boolean isPerm = true;
            for (int j = 0; j < (line.length())/i; j++) {
                char[] chars = new char[currentVariation.length];
                for (int k = 0; k < chars.length; k++) {
                    chars[k] = line.charAt((j*currentVariation.length) + k);
                }
                isPerm &= isPermutation(chars, currentVariation,j);
                if (!isPerm)
                    break;
            }
            if (isPerm) {
                System.out.println(currentVariation.length);
                return;
            }
        }

    }
}
