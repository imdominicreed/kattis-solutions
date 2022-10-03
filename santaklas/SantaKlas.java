import java.util.Scanner;

public class SantaKlas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int v = scanner.nextInt();
        if (v>=0 && v<=180) {
            System.out.print("safe");
            return;
        }
        int angle;
        if (v < 270)
            angle = 90 - (v % 90);
        else
            angle = v % 90;
        System.out.print((int) (h / Math.cos(Math.toRadians(angle))));
    }
}
