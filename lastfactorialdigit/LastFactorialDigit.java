import java.util.Scanner;

public class LastFactorialDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (num<=4) {
                int sum = 1;
                for (int j = 0; j < num; j++) {
                    sum*= num-j;
                }
                System.out.println(sum%10);
            } else{
                System.out.println(0);
            }
        }
    }
}
