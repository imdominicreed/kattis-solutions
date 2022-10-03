import java.util.ArrayList;
import java.util.Scanner;

public class PolynomialMultiplication1 {
    public static int[] createPolynomial(Scanner scanner) {
        int[] poly = new int[scanner.nextInt() + 1];
        for (int i = 0; i < poly.length; i++) {
            poly[i] = scanner.nextInt();
        }
        return poly;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int[] polynomial1 = createPolynomial(scanner);
            int[] polynomial2 = createPolynomial(scanner);
            int[] answer = new int[polynomial1.length+polynomial2.length-1];
            for (int j = 0; j < polynomial1.length; j++) {
                for (int k = 0; k < polynomial2.length; k++) {
                    answer[j+k] += polynomial1[j] * polynomial2[k];

                }
            }
            System.out.println(answer.length-1);
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[j]+" ");
            }
        }

    }
}
