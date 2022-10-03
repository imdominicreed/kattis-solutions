import java.util.Scanner;

public class Timebomb {
    static StringBuilder[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String line = scanner.nextLine();
            if (numbers == null)
                numbers = new StringBuilder[(line.length() + 1) / 4];
            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < 3; k++) {
                    if (numbers[j] == null)
                        numbers[j] = new StringBuilder();
                    numbers[j].append(line.charAt((j * 4) + k));
                }
            }
        }
        String zero = "**** ** ** ****";
        String one = "  *  *  *  *  *";
        String two = "***  *****  ***";
        String three = "***  ****  ****";
        String four = "* ** ****  *  *";
        String five = "****  ***  ****";
        String six = "****  **** ****";
        String seven = "***  *  *  *  *";
        String eight = "**** ***** ****";
        String nine = "**** ****  ****";
        int num = 0;
        boolean invalid = false;
        for (int i = 0; i < numbers.length; i++) {
            int digit;
            if (numbers[i].toString().equals(zero))
                digit = 0;
            else if (numbers[i].toString().equals(one))
                digit = 1;
            else if (numbers[i].toString().equals(two))
                digit = 2;
            else if (numbers[i].toString().equals(three))
                digit = 3;
            else if (numbers[i].toString().equals(four))
                digit = 4;
            else if (numbers[i].toString().equals(five))
                digit = 5;
            else if (numbers[i].toString().equals(six))
                digit = 6;
            else if (numbers[i].toString().equals(seven))
                digit = 7;
            else if (numbers[i].toString().equals(eight))
                digit = 8;
            else if (numbers[i].toString().equals(nine))
                digit = 9;
            else {
                invalid = true;
                break;
            }
            num += (digit * Math.pow(10, (numbers.length - (i+1))));
        }
        if (invalid || num % 6 != 0)
            System.out.println("BOOM!!");
        else
            System.out.println("BEER!!");
    }
}
