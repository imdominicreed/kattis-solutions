import java.util.Scanner;

public class Sjecista {
    public static int factorial(int num) {

       int answer = 1;
        for (int i = 0; i < num  ; i++) {
            answer *= num-i;
        }
        return answer;
    }
    public static int specialFactorial(int num) {

        int answer = 1;
        for (int i = 0; i < (num -(num -4))  ; i++) {
            answer *= num-i;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        System.out.println(specialFactorial(vertices)/(factorial(4)));

    }
}
