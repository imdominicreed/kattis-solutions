import java.util.Scanner;

public class BossBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pillars = scanner.nextInt();
        if (pillars <= 2) {
            System.out.println(1);
        } else
            System.out.println(pillars-2);
    }
}
