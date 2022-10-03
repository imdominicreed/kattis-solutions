import java.util.Scanner;

public class TheEasiestProblem {
    public static int SumOfDigits(int n) {
        int sum = 0;
        String  nString = String.valueOf(n);
        for (int i = 0; i < nString.length(); i++) {
            int mod = n % 10;
            sum += mod;
            n = (n-mod)/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        while(num != 0) {
            int counter = 11;
            int sumofN = SumOfDigits(num);
            while (SumOfDigits(counter*num) != sumofN) {
                counter++;
            }
            System.out.println(counter);
            num =scanner.nextInt();

        }
    }
}
