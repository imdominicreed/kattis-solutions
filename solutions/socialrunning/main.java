import java.awt.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] distances = new int[n];

        for(var i =0; i<n; i++) {
            distances[i] = scanner.nextInt();
        }
        int sum = distances[0] + distances[n-2];

        for(var i =1; i<n; i++) {
            int a = i >1 ? i-2: (n-1);
            int possible = distances[i] + distances[a];

         sum = (possible) < sum ? possible : sum;
        }
        System.out.println(sum);
    }
}
