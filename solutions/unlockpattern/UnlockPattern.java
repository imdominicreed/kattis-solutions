import com.sun.jdi.FloatType;

import java.util.ArrayList;
import java.util.Scanner;

public class UnlockPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[3][3];
        int[] position = new int[9];
        for (int i = 0; i < 9; i++) {
                int num = scanner.nextInt();
                grid[i/3][i % 3] = num;
                position[num-1] = i;
            }
        double sum = 0;
        for (int i = 0; i < 8; i++) {
            double num = position[i];
            double yFirst = (int) num/3;
            double xFirst =  num % 3;
            double num2 = position[i+1];
            double ySecond = (int) num2/3;
            double xSecond = (int) num2 % 3;
            double yDiff = yFirst-ySecond;
            double xDiff = xFirst-xSecond;
            sum += Math.sqrt(Math.pow(yDiff,2) + Math.pow(xDiff, 2));
        }
        System.out.println(sum);
    }
}
