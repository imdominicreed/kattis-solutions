import java.util.Scanner;

public class TriangleDrama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        int[] ret = new int[3];
        int best = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int product = m[i][j] * m[i][k] * m[j][k];
                    if(best < product) ret = new int[] {i+1,j+1,k+1};
                    best = Math.max(best, product);
                }
            }
        }
        System.out.println(ret[0] + " " + ret[1] + " " + ret[2]);
    }
}
