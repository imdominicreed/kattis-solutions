

import java.util.Scanner;

public class JohnnyApplesack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int trips = (int) Math.ceil((double) N / K);
        int traveled = 1;
        while(trips != 0) {
            traveled++;
            N-= trips;
            trips = (int) Math.ceil((double) N / K);
        }
        System.out.println(traveled);
    }
}
