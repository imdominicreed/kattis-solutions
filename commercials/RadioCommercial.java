import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.rmi.activation.ActivationSystem;
import java.util.Arrays;
import java.util.Scanner;

public class RadioCommercial {
    static BufferedReader  bi;
    static boolean firstTime = true;
    public static int[] readInts() throws IOException {
        String[] line = bi.readLine().split(" ");
        int[] num = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            num[i] = Integer.parseInt(line[i]);
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        bi = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = readInts();
        int[] secondLine = readInts();
        int cases = firstLine[0];
        int commCost = firstLine[1];
        int answer = 0;
        int currentBest = 0;
        for (int i = 0; i < cases; i++) {
            int num =secondLine[i] - commCost ;
            currentBest = Math.max(num, currentBest + num);
            answer = Math.max(answer, currentBest);
        }
        System.out.println(answer);
    }
}

