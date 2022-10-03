import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class kattis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String answer = "";
            String message = scanner.nextLine();
            int length = (int) Math.sqrt(message.length());
            char[][] array = new char[length][length];
            int counter = 0;
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    array[j][k] = message.charAt(counter);
                    counter++;
                }
            }
            for (int j = length-1; j > -1 ; j--) {
                for (int k = 0; k < length; k++) {
                    answer += array[k][j];
                }
            }
            System.out.println(answer);
        }
        }
    }
