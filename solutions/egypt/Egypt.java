import java.util.Arrays;
import java.util.Scanner;

public class Egypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rows = new int[3];
        int sum  = 0;
        for (int i = 0; i < 3; i++) {
            rows[i] = scanner.nextInt();
            sum += rows[i];
        }

        while (sum != 0) {
            Arrays.sort(rows);
            if ((rows[0]*rows[0]) + (rows[1]*rows[1]) == rows[2]*rows[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
            sum  = 0;
            for (int i = 0; i < 3; i++) {
                rows[i] = scanner.nextInt();
                sum += rows[i];
            }
        }
    }
}
