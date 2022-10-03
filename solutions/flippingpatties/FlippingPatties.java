import java.util.Scanner;

public class FlippingPatties {
    public static void main(String[] args) {
        int[] arr = new int[44000];
        Scanner scanner = new Scanner(System.in);
        int  n = scanner.nextInt();
        int r = 0;
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int t = scanner.nextInt();
            r = Math.max(r, ++arr[t]);
            r = Math.max(r, ++arr[t-d]);
            r = Math.max(r, ++arr[t-(d+d)]);
        }
        System.out.println((int)Math.ceil(r/2D));
    }
}
