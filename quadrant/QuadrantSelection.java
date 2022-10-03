import java.util.Scanner;

public class QuadrantSelection {
    public static boolean isPositive(int num) {
        if (Math.signum(num) == 1.0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (isPositive(x)) {
            if (isPositive(scanner.nextInt())) {
                System.out.println(1);
            } else {
                System.out.println(4);
            }
        } else {
            if (isPositive(scanner.nextInt())){
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
