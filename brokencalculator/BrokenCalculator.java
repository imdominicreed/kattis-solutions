import java.util.Scanner;

public class BrokenCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        long prev = 1;
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            char op = line[1].charAt(0);
            long num1 = Integer.parseInt(line[0]);
            long num2 = Integer.parseInt(line[2]);
            switch (op) {
                case '+':
                    prev = (num1+num2) - prev;
                    break;
                case '-':
                    prev *= (num1 - num2);
                    break;
                case '*':
                    prev = (num1*num2)*(num1*num2);
                    break;
                case '/':
                    prev = num1/2 + (num1 %2 == 0 ? 0 : 1);
                    break;
            }
            System.out.println(prev);
        }
    }
}
