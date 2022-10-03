import java.util.HashMap;
import java.util.Scanner;

public class HayPoints {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dic = scanner.nextInt();
        int texts = scanner.nextInt();
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < dic; i++) {
            dict.put(scanner.next(), scanner.nextInt());
        }
        for (int i = 0; i < texts; i++) {
            int sum = 0;
            String word = scanner.next();
            while (!word.equals(".")) {
                if (dict.containsKey(word)) {
                    sum += dict.get(word);
                }
                word = scanner.next();
            }
            System.out.println(sum);
        }
    }
}

