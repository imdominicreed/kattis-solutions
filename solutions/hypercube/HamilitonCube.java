import java.util.Scanner;

public class HamilitonCube {
    static long getGrayCode(long code) {
        long index = 0;
        while (code != 0) {
            index ^= code;
            code >>= 1;
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        System.out.print(-getGrayCode(scanner.nextLong(2)) + getGrayCode(scanner.nextLong(2))-1);
    }
}
