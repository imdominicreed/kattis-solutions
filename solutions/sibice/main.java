
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        int N = test.nextInt();
        int W = test.nextInt();
        int H = test.nextInt();
        for(var i = 0; i<N; i++) {

            int length = test.nextInt();
            if (length <= (Math.sqrt((W * W) + (H * H)))) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

}
    }
