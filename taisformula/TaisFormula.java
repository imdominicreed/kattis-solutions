import java.util.Scanner;

public class TaisFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double prevL = scanner.nextDouble();
        double prevM = scanner.nextDouble();
        double sum = 0;
        for (int i = 1; i < n; i++) {
            double l = scanner.nextDouble();
            double m = scanner.nextDouble();
            sum += ((prevM + m)/2) * (l - prevL);
            prevL = l;
            prevM = m;
        }
        System.out.println(sum/1000D);
    }
}
