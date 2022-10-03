import java.util.Scanner;

public class PowerStrips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }
    public static void solve(Scanner scanner) {
        int k = scanner.nextInt();
        int r = 1;
        for (int i = 0; i < k; i++) {
            r += scanner.nextInt()-1;
        }
        System.out.println(r);
    }
}
