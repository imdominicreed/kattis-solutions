import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FallingApart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (i %2 == 0)
                a += arr[i];
            else
                b += arr[i];
        }
        System.out.print(a + " " + b);
    }
}
