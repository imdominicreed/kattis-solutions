import java.util.HashSet;
import java.util.Scanner;

public class NinetyNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 2;
        System.out.println(score);

        while (score != 99) {
            score = scanner.nextInt();
            if (score == 99) {
                break;
            }
            if (score%3 == 0) {
                score += (int) Math.ceil(Math.random() * 2);
            } else {
                score = score +(3-score %3);
            }
            System.out.println(score);
        }
    }
}
