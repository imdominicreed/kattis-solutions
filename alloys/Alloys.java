import java.util.Scanner;

public class Alloys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double SEK = scanner.nextDouble();
        if (SEK > 1){
            System.out.println(0.25);
        } else {
            System.out.println(Math.pow(SEK/2D,2));
        }

    }
}
