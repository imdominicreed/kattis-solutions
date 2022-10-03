
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        int N = test.nextInt();
        int start = 3;
        int squares = 1;
        for(var i = 1; i<N; i++) {
            squares *= 2;
            start += squares;

        }


        System.out.println((int) Math.pow(start,2));
}
    }
