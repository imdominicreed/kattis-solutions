import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class studying {
    static double[][] functions;
    static double time;
    static boolean repeat;
    static int counter;

    public static double[] tweaker() {
        double[] tweakAmounts = {100, 10, 1, 0.1, 0.01, 0.001};
        double[] amounts = new double[functions.length];
        Arrays.fill(amounts, time / functions.length);
        for (double tweak : tweakAmounts) {
            //for (int i = 0; i < 50; i++) {
            repeat = false;
            counter = 0;
            while (!repeat) {
                counter++;
                amounts = tweakAmount(amounts, tweak);
            }
            if (counter > 65) {
                //throw new RuntimeException(":(");
            }
        }
        return amounts;
    }

    public static double[] tweakAmount(double[] amounts, double tweak) {
        double[] tweakedAmount = new double[amounts.length];
        double[] answerAmount = amounts.clone();
        double totalTime = calculateGrade(amounts);
        repeat = true;
        for (int i = 0; i < amounts.length; i++) {
            double totalTimeSum = 0;
            for (int j = 0; j < amounts.length; j++) {
                if (amounts[j] - tweak < 0) {
                    tweakedAmount[j] = 0;
                } else {
                    tweakedAmount[j] = amounts[j] - tweak;
                    totalTimeSum += amounts[j] - tweak;
                }
            }
            tweakedAmount[i] = time - (totalTimeSum - tweakedAmount[i]);
            double calculatedTime = calculateGrade(tweakedAmount);
            if (calculatedTime > 100) {
                continue;
            }
            if (totalTime < calculatedTime) {
                repeat = false;
                answerAmount = tweakedAmount.clone();
                totalTime = calculatedTime;
            }
        }
        return answerAmount;
    }

    public static double calculateGrade(double[] amounts) {
        double sum = 0;
        for (int i = 0; i < functions.length; i++) {
            sum += (functions[i][0] * amounts[i] * amounts[i]) + (functions[i][1] * amounts[i]) + functions[i][2];
        }
        double length = functions.length;
        return sum / length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numFunctions = scanner.nextInt();
        time = scanner.nextInt();
        functions = new double[numFunctions][3];
        for (int i = 0; i < numFunctions; i++) {
            for (int j = 0; j < 3; j++) {
                functions[i][j] = scanner.nextDouble();
            }
        }
        double[] amounts = tweaker();
        System.out.println(calculateGrade(amounts));
    }
}
