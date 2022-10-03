import java.awt.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AreYouListening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextInt();
        double y = scanner.nextInt();
        PriorityQueue<Double> pq = new PriorityQueue<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            pq.add(Math.hypot(scanner.nextInt() - x, scanner.nextInt() - y) - scanner.nextInt());
        }
        pq.poll();
        pq.poll();
        int min = pq.poll().intValue();
        System.out.println(Math.max(0, min));
    }
}
