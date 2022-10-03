import java.util.Scanner;

public class CuttingBrownies {
    static final int MAX = 501;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int[] a = new int[] {scanner.nextInt(), scanner.nextInt()};
            String name = scanner.next();
            int turn = name.equals("Harry") ? 1 : 0;
            while (a[turn%2] != 1) a[turn++ % 2] /= 2;
            int start = name.equals("Harry") ? 1 : 0;
            System.out.println(name + (turn%2 == start ? " cannot win" : " can win"));
        }
    }
}
