import java.awt.*;
import java.util.Scanner;

public class main {
    public static int Basifier(int n, int b) {
        int answer =0;
       while(n != 0) {
        int digit = n%b;
        n = n/b;
        answer+=Math.pow(digit,2);
    }
       return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for(var i =0; i<k; i++) {
            int counter = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(counter + " " +Basifier(n,b));

        }


    }
}
