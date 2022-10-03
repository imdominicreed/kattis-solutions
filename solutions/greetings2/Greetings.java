import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print('h' + "e".repeat((scanner.next().length() -2)*2) + "y");
    }
}
