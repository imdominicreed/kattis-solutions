import java.util.Scanner;

public class SGCoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        num = solve(num, "charlie-pays-to-eve-9-sg-coins");
        num  = solve(num, "icpc-sg-2018-at-nus");
    }
    public static long solve(long num ,String transaction) {
        for (int i = 0; i < transaction.length(); i++) {
            num = (num * 31 + transaction.charAt(i)) % 1000000007;
        }
        for (long i = (long) (10E8)-1; i >= 0; i--) {
            if (i== 218_216_710)
                System.out.println("HERE");
            if (((num * 7 + i) % 1000000007) % 10000000 == 0) {
                num = (num * 7 + i) % 1000000007;
                System.out.println(transaction + " " + i);
                break;
            }
        }
        return num;
    }
}
