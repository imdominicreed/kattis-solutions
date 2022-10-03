import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Platforme {
    static class Platform {
        int l;
        int r;
        int y;
        Platform(int y, int l, int r) {
            this.l = l;
            this.r = r;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Platform[] platforms = new Platform[n];
        for(int i = 0; i < n; i++) {
            platforms[i] = new Platform(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()-1);
        }
        Arrays.sort(platforms, Comparator.comparingInt(o -> o.y));
        int[] floor = new int[10_001];
        int sum = 0;
        for (Platform p : platforms) {
            sum += 2*p.y -(floor[p.l] + floor[p.r]);
            for (int i = p.l; i <= p.r; i++) {
                floor[i] = p.y;
            }
        }
        System.out.println(sum);
    }
}
