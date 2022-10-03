import java.util.Scanner;

public class LockedTreasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cases = scanner.nextInt();
        long[][] cNk = new long[32][32];
        for (int i = 0; i < 31; i++) {
            cNk[i][1] =1;
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 1; j <= i; j++) {
                cNk[i][j] = cNk[i - 1][j - 1] + cNk[i - 1][j];
            }
        }
        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(cNk[n+1][m]);
        }
    }
}
