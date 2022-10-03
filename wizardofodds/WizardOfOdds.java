import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public final class WizardOfOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n =scanner.nextDouble();
        double k = scanner.nextDouble();
        n = Math.log(n) / Math.log(2D);
        System.out.println(k >= n ? "Your wish is granted!" : "You will become a flying monkey!");
    }
}
