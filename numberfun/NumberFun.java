import java.util.Scanner;

public class NumberFun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(var i = 0; i< n;i++) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            System.out.println((a+b==c) || (a-b==c) || (b-a == c) || (a*b == c) || (a/b==c) || (b/a==c) ? "Possible" : "Impossible");
        }
    }
}



