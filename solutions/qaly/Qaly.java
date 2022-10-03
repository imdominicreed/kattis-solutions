import java.util.Scanner;

public class Qaly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double s = 0;
        for (int i = 0; i < n; i++) {
            s += scanner.nextDouble() * scanner.nextDouble();
        }
        System.out.println(s);
    }
}
