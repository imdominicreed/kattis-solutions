
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        int N = test.nextInt();
        int sum = 0;
        int number = 0;
        int power = 0;
        for(var i = 0; i<N; i++) {
            int P = test.nextInt();
            power = P % 10;
            number = (P-power)/10;
            sum += Math.pow(number, power);
        }
System.out.println(sum);

}
    }
