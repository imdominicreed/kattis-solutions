import java.util.HashMap;
import java.util.Scanner;

public class WordsForNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ones = new String[10];
        String[] tens = new String[10];
        ones[0] = "zero";
        ones[1] = "one";
        ones[2] = "two";
        ones[3] = "three";
        ones[4] = "four";
        ones[5] = "five";
        ones[6] = "six";
        ones[7] = "seven";
        ones[8] = "eight";
        ones[9] = "nine";
        tens[2] = "twenty";
        tens[3] = "thirty";
        tens[4] = "forty";
        tens[5] = "fifty";
        tens[6] = "sixty";
        tens[7] = "seventy";
        tens[8] = "eighty";
        tens[9] = "ninety";
        HashMap<Integer, String> special = new HashMap<>();
        special.put(10, "ten");
        special.put(11, "eleven");
        special.put(12, "twelve");
        special.put(13, "thirteen");
        special.put(14, "fourteen");
        special.put(15, "fifteen");
        special.put(16, "sixteen");
        special.put(17, "seventeen");
        special.put(18, "eighteen");
        special.put(19, "nineteen");

        while (scanner.hasNext()) {
            StringBuilder ans = new StringBuilder();
            String[] words = scanner.nextLine().split(" ");
            for (String word: words) {
                try{
                    int parse = Integer.parseInt(word);
                    if (special.containsKey(parse)) {
                        ans.append(special.get(parse));
                        ans.append(" ");
                        continue;
                    }
                    if (word.length() == 2) {
                        ans.append(tens[(parse/10) % 10]);
                        if (parse%10 == 0) {
                            ans.append(" ");
                            continue;
                        }
                        ans.append("-");
                    }
                    ans.append(ones[parse % 10]);
                    ans.append(" ");
                } catch (NumberFormatException e) {
                    ans.append(word);
                    ans.append(" ");
                }
            }
            System.out.println(ans.toString());
        }

    }
}
