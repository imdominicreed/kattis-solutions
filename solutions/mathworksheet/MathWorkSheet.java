import java.util.ArrayList;
import java.util.Scanner;

public class MathWorkSheet {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int problems = scanner.nextInt();
        while (true) {
            int spaceLength = 0;

            String[] numbers = new String[problems];
            for (int j = 0; j < problems; j++) {
                int num1 = scanner.nextInt();
                String op = scanner.next();
                int num2 = scanner.nextInt();
                int answer;
                if (op.equals("*")) {
                    answer = num1 * num2;
                } else if (op.equals("-")) {
                    answer = num1 - num2;
                } else {
                    answer = num1 + num2;
                }
                String ans = String.valueOf(answer);
                spaceLength = Math.max(ans.length(), spaceLength);
                numbers[j] = ans;
            }
            ArrayList<String> lines = new ArrayList<>();
            StringBuilder line = new StringBuilder();
            for (String number : numbers) {
                int numSpaces = spaceLength - number.length() + 1;

                if (numSpaces<= -1) {
                    numSpaces = 0;
                }
                if (line.length() + numSpaces + number.length() > 50) {
                    lines.add(line.toString());
                    line = new StringBuilder();
                }
                if (line.length() ==0) {
                    numSpaces = Math.max(spaceLength - number.length(), 0);
                }
                line.append(" ".repeat(numSpaces));
                line.append(number);
            }
            lines.add(line.toString());
            for (String answerLine : lines) {
                System.out.println(answerLine);
            }

            problems = scanner.nextInt();
            if (problems == 0) {
                return;
            }
            System.out.println();
        }
    }
}
