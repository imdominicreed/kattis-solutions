import java.util.Arrays;
import java.util.Scanner;

public class AboveAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            double sum = 0;
            for (int k = 0; k < n; k++) {
                arr[k] += scanner.nextInt();
                sum += arr[k];
            }
            double avg = sum / n;
            int num = 0;
            Arrays.sort(arr);
            while (num < arr.length && arr[num] <= avg) {
                num++;
            }
            double percent = ((double) n - num) / n;
            percent *= 100;
            System.out.printf("%.3f", percent);
            System.out.print("%\n");
        }
    }
}
