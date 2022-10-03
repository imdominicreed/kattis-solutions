import java.util.Arrays;
import java.util.Scanner;

public class BusNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        Arrays.sort(stops);
        boolean shortening = false;
        int first = 0;
        int length = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stops.length; i++) {
            if (i + 1 != stops.length && stops[i + 1] == stops[i] + 1) {
                length++;
                if (!shortening) {
                    first = stops[i];
                    shortening = true;
                }
                continue;
            }
            if (length == 1) {
                ans.append(first);
                ans.append(' ');
                ans.append(stops[i]);
                ans.append(' ');
                shortening = false;
                length =0;
                continue;
            }
            if (shortening) {
                ans.append(first);
                ans.append('-');
                ans.append(stops[i]);
                shortening = false;
                length = 0;
            } else
                ans.append(stops[i]);
            ans.append(' ');
        }
        System.out.print(ans.toString());
    }
}
