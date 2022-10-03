import java.util.Scanner;

public class ADifferentProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                System.out.println(Math.abs(scanner.nextLong() - scanner.nextLong()));
            } catch (Exception e) {
                return;
            }
        }
    }
}
