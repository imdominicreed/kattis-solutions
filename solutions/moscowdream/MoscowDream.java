import java.util.Scanner;

public class MoscowDream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int easyProblem = scanner.nextInt();
        int mediumProblem = scanner.nextInt();
        int hardProblem = scanner.nextInt();
        int nums = scanner.nextInt();
        if (easyProblem >= 1 && mediumProblem >= 1 && hardProblem >= 1 && nums >= 3 && (easyProblem+hardProblem+mediumProblem) >= nums) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
