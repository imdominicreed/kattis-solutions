import java.util.ArrayList;
import java.util.Scanner;

public class Checkboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] whiteRows = new int[n];
        int[] whiteColumns = new int[n];
        scanner.nextLine();
        int[] columnCounter = new int[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                if (line.contains("WWW") || line.contains("BBB")) {
                    System.out.println(0);
                    return;
                }
                if ('W' == line.charAt(j)) {
                    whiteColumns[j]++;
                    whiteRows[i]++;
                    columnCounter[j]++;
                    if (columnCounter[j] >= 3) {
                        System.out.println(0);
                        return;
                    }
                } else {
                    columnCounter[j] = 0;
                }
            }
        }
        int numRows =whiteRows[0];
        int numColumns = whiteColumns[0];
        for (int i = 0; i < n; i++) {
            if (numRows != whiteRows[i] || numColumns != whiteColumns[i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
