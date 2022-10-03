import javax.sound.sampled.Line;
import java.util.Scanner;

public class InverseFactorial2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int counter = 1;
        double factLength = 0;
        if (line.length()<3) {
            int num = Integer.parseInt(line);
            int fact = 1;
            while (fact != num) {
                counter++;
                fact *= counter;
            }
            System.out.println(counter);
            return;
        }
        while (line.length() != Math.ceil(factLength)) {
            factLength += Math.log10(counter);
            counter++;
        }
        System.out.println(counter-1);
    }
}
