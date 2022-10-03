import java.util.Scanner;
import java.util.Stack;

public class DelimiterSoup {
    public static char getComplement(char l) {
        switch (l) {
            case '}': return '{';
            case  ')': return '(';
            case ']': return '[';
        }
         return '!';

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            char letter = line.charAt(i);
            if (letter == ' ')  continue;
            else if (getComplement(letter) == '!') s.add(letter);
            else if (s.isEmpty() || s.pop() != getComplement(letter)) {
                System.out.println(letter + " " + i);
                return;
            }
        }
        System.out.println("ok so far");
    }
}
