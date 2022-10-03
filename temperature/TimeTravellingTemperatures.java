import java.awt.*;
import java.util.Scanner;

public class TimeTravellingTemperatures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double starting = scanner.nextDouble();
        double scale = scanner.nextDouble();
        if ((scale == 1) && starting == 0) {
            System.out.println("ALL GOOD");
        } else if(scale == 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            if (starting != 0) {
                System.out.println(starting / (scale - 1) * -1);
            } else  {
                System.out.println(0);
            }
        }
    }
}
