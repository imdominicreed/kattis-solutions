import java.util.Scanner;

public class YingandYangStones {
    public static char[] stones;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringStones = scanner.nextLine();
        stones = stringStones.toCharArray();
        int white = 0;
        int black = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == 'W') {
                white++;
            } else {
                black++;
            }
        }
        if(white == black){
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
