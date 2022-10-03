import java.util.Scanner;

public class BabylonianNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            StringBuilder line = new StringBuilder(scanner.nextLine());
            line.reverse();
            long power = 0;
            long currentNum = 0;
            long answer = 0;
            long lengthofNumber = 0;
            for (int j = 0; j < line.length(); j++) {
                char letter = line.charAt(j);
                if (letter == ',') {
                    answer += currentNum * Math.pow(60, power);
                    currentNum = 0;
                    lengthofNumber = 0;
                    power++;
                } else {
                    currentNum += Math.pow(10, lengthofNumber) * (letter - '0');
                    lengthofNumber++;
                }
            }
            System.out.println(answer + (currentNum * (long) Math.pow(60, power)));
        }
    }
}
