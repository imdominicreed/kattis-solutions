import java.util.Scanner;

public class MathHomework {
    static StringBuilder answer;

    static void printAndReset(int aLegs, int bLegs, int cLegs) {
        answer.append(aLegs);
        answer.append(" ");
        answer.append(bLegs);
        answer.append(" ");
        answer.append(cLegs);
        answer.append("\n");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int l = scanner.nextInt();
        answer = new StringBuilder();
        for (int i = 0; i < 251; i++) {
            if ((a * i) > l)
                break;
            else if ((a * i) == l) {
                printAndReset(i, 0, 0);
                break;
            }
            for (int j = 0; j < 251; j++) {
                int currentNum = ((a * i) + (b * j));
                if (currentNum > l)
                    break;
                else if (currentNum == l)
                    printAndReset(i, j, 0);
                else if ((l - currentNum) % c == 0)
                    printAndReset(i, j, (l - currentNum) / c);

            }
        }
        if (answer.toString().isEmpty())
            System.out.print("impossible");
        else {
            answer.deleteCharAt(answer.length() - 1);
            System.out.print(answer.toString());
        }

    }
}
