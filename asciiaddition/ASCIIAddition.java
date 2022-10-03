import java.util.Scanner;

public class ASCIIAddition {
    static String zero = "xxxxx\n" +
            "x...x\n" +
            "x...x\n" +
            "x...x\n" +
            "x...x\n" +
            "x...x\n" +
            "xxxxx";
    static String one = "....x\n" +
            "....x\n" +
            "....x\n" +
            "....x\n" +
            "....x\n" +
            "....x\n" +
            "....x";
    static String two = "xxxxx\n" +
            "....x\n" +
            "....x\n" +
            "xxxxx\n" +
            "x....\n" +
            "x....\n" +
            "xxxxx";
    static String three = "xxxxx\n" +
            "....x\n" +
            "....x\n" +
            "xxxxx\n" +
            "....x\n" +
            "....x\n" +
            "xxxxx";
    static String four = "x...x\n" +
            "x...x\n" +
            "x...x\n" +
            "xxxxx\n" +
            "....x\n" +
            "....x\n" +
            "....x";
    static String five = "xxxxx\n" +
            "x....\n" +
            "x....\n" +
            "xxxxx\n" +
            "....x\n" +
            "....x\n" +
            "xxxxx";
    static String six = "xxxxx\n" +
            "x....\n" +
            "x....\n" +
            "xxxxx\n" +
            "x...x\n" +
            "x...x\n" +
            "xxxxx";
    static String seven = "xxxxx\n" +
            "....x\n" +
            "....x\n" +
            "....x\n" +
            "....x\n" +
            "....x\n" +
            "....x";
    static String eight = "xxxxx\n" +
            "x...x\n" +
            "x...x\n" +
            "xxxxx\n" +
            "x...x\n" +
            "x...x\n" +
            "xxxxx";
    static String nine = "xxxxx\n" +
            "x...x\n" +
            "x...x\n" +
            "xxxxx\n" +
            "....x\n" +
            "....x\n" +
            "xxxxx";
    static String plus = ".....\n" +
            "..x..\n" +
            "..x..\n" +
            "xxxxx\n" +
            "..x..\n" +
            "..x..\n" +
            ".....";
    static String getString(int num) {
        if (num == 0)
            return zero;
        else if (num == 1)
            return one;
        else if (num == 2)
            return two;
        else if (num == 3)
            return three;
        else if (num == 4)
            return four;
        else if (num == 5)
            return five;
        else if (num == 6)
            return six;
        else if (num == 7)
            return seven;
        else if (num == 8)
            return eight;
        else
            return nine;
    }
    static int getNumber(String num) {
        if (num.equals(zero))
            return 0;
        else if (num.equals(one))
            return 1;
        else if (num.equals(two))
            return 2;
        else if (num.equals(three))
            return 3;
        else if (num.equals(four))
            return 4;
        else if (num.equals(five))
            return 5;
        else if (num.equals(six))
            return 6;
        else if (num.equals(seven))
            return 7;
        else if (num.equals(eight))
            return 8;
        else if (num.equals(nine))
            return 9;
        else
            return -1;
    }

    static StringBuilder[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            String line = scanner.nextLine();
            if (numbers == null)
                numbers = new StringBuilder[(line.length() + 1) / 6];
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == null)
                    numbers[j] = new StringBuilder();
                for (int k = 0; k < 5; k++) {
                    numbers[j].append(line.charAt((j * 6) + k));
                }
                if (i != 6)
                    numbers[j].append("\n");
            }
        }
        long num1 = 0;
        long num2 = 0;
        boolean onNum1 = true;
        for (StringBuilder sb : numbers) {
            int digit = getNumber(sb.toString());
            if (digit == -1)
                onNum1 = false;
            else if(onNum1)
                num1 = num1 * 10 + digit;
            else
                num2 = num2 * 10 + digit;
        }
        long added = num1 + num2;
        StringBuilder answer = new StringBuilder();
        int length = (int) Math.log10(added) +1;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < length; j++) {
                int digit = (int) ((added / Math.pow(10, length - 1 - j)) % 10);
                String num = getString(digit);
                for (int k = 0; k < 5; k++) {
                    answer.append(num.charAt(k + (i * 6)));
                }
                if (j+1 != length)
                    answer.append('.');
                else
                    answer.append('\n');
            }
        }
        System.out.print(answer.toString());
    }
}
