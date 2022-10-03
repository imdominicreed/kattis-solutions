import java.util.Scanner;

public class Mia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Player player1 = new Player(scanner.nextInt(), scanner.nextInt());
            Player player2 = new Player(scanner.nextInt(), scanner.nextInt());
            if (player1.end && player2.end) {
                return;
            }
            if (player1.typing == player2.typing) {
                if (player1.typing == 3 || (player1.value == player2.value)) {
                    System.out.println("Tie.");
                } else if (player1.value > player2.value) {
                    System.out.println("Player 1 wins.");
                } else {
                    System.out.println("Player 2 wins.");
                }
            } else if (player1.typing > player2.typing) {
                System.out.println("Player 1 wins.");
            } else {
                System.out.println("Player 2 wins.");
            }
        }
    }
}

class Player {
    public int typing;
    public int value;
    public boolean end;

    Player(int a, int b) {
        end = a == 0 && b == 0;
        if (a == b) {
            typing = 2;
            value = a;
        } else if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
            typing = 3;
        } else {
            typing = 1;
            value = Math.max((b * 10) + a, (a*10) +b);
        }
    }
}
