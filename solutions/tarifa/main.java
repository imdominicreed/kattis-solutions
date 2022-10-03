
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        int X = test.nextInt();
        int N = test.nextInt();
        int sum = X;
        for (var i = 0; i < N; i++) {
            int P = test.nextInt();
            sum += (X-P);
        }
        System.out.println(sum);
    }
}
