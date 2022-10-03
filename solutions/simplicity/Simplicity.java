import java.util.HashMap;
import java.util.Scanner;

public class Simplicity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] string = scanner.next().toCharArray();
        HashMap<Character, Integer> letters = new HashMap<>();
        for (char letter: string) {
            letters.putIfAbsent(letter, 0);
            letters.put(letter, letters.get(letter) + 1);
        }
        int max1 = 0;
        int max2 = 0;
        for (char letter: letters.keySet()) {
            if (max1<letters.get(letter)) {
                if (max1 > max2) {
                    max2 = max1;
                }
                max1 = letters.get(letter);
            } else if (max2 < letters.get(letter)){
                max2 = letters.get(letter);
            }
        }
        System.out.println(string.length-max1-max2);
    }
}
