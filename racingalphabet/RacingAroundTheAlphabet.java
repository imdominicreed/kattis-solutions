import java.util.HashMap;
import java.util.Scanner;

public class RacingAroundTheAlphabet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double lengthofLetter = (60*Math.PI);
        double answer = 0;
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < cases; i++) {
            String line = scanner.nextLine();;
            int dist = 0;
            for (int j = 0; j < line.length() -1; j++) {
                int location1 = line.charAt(j) == ' ' ? 27 : line.charAt(j) == '\'' ? 28 : line.charAt(j) - 64;
                int location2 = line.charAt(j+1) == ' ' ? 27 : line.charAt(j+1) == '\'' ? 28 : line.charAt(j+1) - 64;
                int diff = location1 - location2 < 0 ? location2 - location1 : location1 - location2;
                dist += diff > 14 ? 28 - diff : diff;
            }
            System.out.println(dist*lengthofLetter/420+line.length());
        }

    }
}
