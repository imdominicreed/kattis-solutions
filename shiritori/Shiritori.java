import java.util.HashSet;
import java.util.Scanner;

public class Shiritori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int words = Integer.parseInt(scanner.nextLine());
        HashSet<String> wordSet = new HashSet<>();
        char previousChar = 0;
        boolean firstTime = true;
        for (int i = 0; i < words; i++) {
            String word = scanner.nextLine();
            if (firstTime) {
                previousChar = word.charAt(0);
            }
            if (wordSet.contains(word)) {
                System.out.println("Player " + ((i%2) +1) + " lost");
                return;
            } else if(previousChar == word.charAt(0)){
                wordSet.add(word);
                previousChar = word.charAt(word.length() - 1);
                firstTime = false;
            } else {
                System.out.println("Player " + ((i%2) +1) + " lost");
                return;
            }
        }
        System.out.println("Fair game");
    }
}
