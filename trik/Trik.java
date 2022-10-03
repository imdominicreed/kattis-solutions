import java.util.Scanner;

public class Trik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] letters = scanner.nextLine().split("");
        boolean[] ball = new boolean[3];
        ball[0] = true;
        for (int i = 0; i < letters.length; i++) {
            boolean holder = false;
            if (letters[i].equals("A")) {
                holder = ball[0];
                ball[0] = ball[1];
                ball[1] = holder;
            }
            if (letters[i].equals("B")) {
                holder = ball[1];
                ball[1] = ball[2];
                ball[2] = holder;
            }
            if (letters[i].equals("C")) {
                holder = ball[0];
                ball[0] = ball[2];
                ball[2] = holder;
            }
        }
        for (int i = 0; i < ball.length; i++) {
            if (ball[i])  {
                System.out.println(i+1);
            }
        }
    }
}
