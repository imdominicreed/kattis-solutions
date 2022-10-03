import java.util.Scanner;

public class ReversedBinaryNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long reversed = 0;
        while(num != 0) {
            reversed <<= 1;
            if ((num & 1) != 0) {
                reversed |= 1;
            }
            num >>= 1;
        }
        System.out.println(reversed);
    }
}
