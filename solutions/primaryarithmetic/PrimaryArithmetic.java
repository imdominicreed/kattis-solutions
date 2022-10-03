import java.util.Scanner;

public class PrimaryArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        while (a > 0 || b != 0) {
            int sum = 0;
            int numCarries = 0;
            int carry = 0;
            while (a > 0 ||  b > 0) {
                sum += carry + (a % 10) + (b % 10);
                if (sum >= 10) {
                    numCarries++;
                }
                carry = sum/10;
                sum = 0;
                a /= 10;
                b /= 10;
            }
           if (numCarries == 0)
               System.out.println("No carry operation.");
           else if(numCarries == 1)
               System.out.println("1 carry operation.");
           else
               System.out.println(numCarries + " carry operations.");
            a = scanner.nextInt();
            b = scanner.nextInt();
        }
    }
}
