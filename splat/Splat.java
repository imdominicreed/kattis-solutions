import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Splat {
    static class Circle {
        String color;
        double radius;
        double x;
        double y;
        Circle(double x, double y, double v, String color) {
            this.color = color;
            this.x = x;
            this.y = y;
            radius = Math.sqrt(v / Math.PI);
        }
        boolean inCircle(double x, double y) {
            return radius >= Math.hypot(this.x - x, this.y - y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt();
            Circle[] circles = new Circle[n];
            for (int j = n-1; j > -1 ; j--) {
                circles[j] = new Circle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.next());
            }
            int m = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                boolean noColor = true;
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                for(Circle circle : circles) {
                    if (circle.inCircle(x,y)) {
                        noColor = false;
                        bw.write(circle.color);
                        break;
                    }
                }
                if (noColor)
                    bw.write("white");
                bw.newLine();
            }
        }
        bw.flush();
    }
}
