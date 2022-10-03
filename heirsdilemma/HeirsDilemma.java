import java.util.HashSet;
import java.util.Scanner;

public class HeirsDilemma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        int total = 0;
        for (int i = low; i < high + 1; i++) {
            if (checkDivisibility(i))
                total++;
        }
        System.out.println(total);
    }

    public static boolean checkDivisibility(int n) {
        boolean[] digits = new boolean[10];
        digits[0] = true;
        int num = n;
        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            if (digits[digit] || n % digit != 0)
                return false;
            digits[digit] = true;
        }
        return true;
    }
}
