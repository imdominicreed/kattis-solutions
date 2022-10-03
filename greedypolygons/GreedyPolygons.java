import java.util.Scanner;

public class GreedyPolygons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int distanceExpansion = scanner.nextInt();
            int iterations = scanner.nextInt();
            int r = iterations * distanceExpansion;
            double s = Math.sqrt((2*r*r) * (1- Math.cos(2* Math.PI/n)));
            double b = (Math.sin(Math.PI/n)/(Math.sin(2*(Math.PI/n)))) * s;
            double answer = n * (Math.pow(a+(2*b),2)/(4*Math.tan(Math.PI/n)) - Math.sqrt((4*Math.pow(b,2)-Math.pow(s,2))/4) * (s/2) + Math.pow(r, 2) * Math.PI/n - s * (r-r *(1-Math.cos(Math.PI/n)))/2);
            System.out.println(answer);
        }
    }
}
