import java.util.Scanner;
public class FrostingOnTheCake {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int cases = scanner.nextInt();
        long[] lengthSections = new long[3];
        long[] answer = new long[3];
        for (int i = 0; i < cases; i++) {
            lengthSections[i%3] += scanner.nextInt();
        }
        for (int i = 0; i < cases; i++) {
            long num = scanner.nextInt();
            answer[(i+2)%3] += num*lengthSections[0];
            answer[(i)%3] += num*lengthSections[1];
            answer[(i+1)%3] += num*lengthSections[2];
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
