import java.util.Scanner;

public class HarshadNumbers {
    public static int sumOfDigits(int n) {
        int length = (int) Math.log10(n) +1;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum+= n % 10;

            int num =(n % 10);
            n=  (n-num)/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (true){
        if (n % sumOfDigits(n) == 0) {
            System.out.println(n);
            return;
        }
        n++;
        }
    }
}
