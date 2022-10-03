import java.util.Scanner;

public class Bieje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pieces = {1,1,2,2,2,8};
        for (int i = 0; i < pieces.length; i++) {
            System.out.print(pieces[i]-scanner.nextInt() + " ");
        }
    }
}
