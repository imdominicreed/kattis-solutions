import java.util.Scanner;

public class PebbleSolitaire {
    public static int answer = 12;
    public static char[] pebbleChess(char[] set) {
        boolean changed = false;
        char[] bestSet = set.clone();
        for (int i = 0; i < set.length; i++) {
            char[] firstSet = set.clone();
            if (i < set.length - 2) {
                if (set[i] == 'o' && set[i + 1] == 'o' && set[i + 2] == '-') {
                    firstSet[i] = '-';
                    firstSet[i + 1] = '-';
                    firstSet[i + 2] = 'o';
                    firstSet = pebbleChess(firstSet);
                    changed = true;
                }
            }
                char[] secondSet = set.clone();
                if (i > 2) {
                    if (set[i] == 'o' && set[i - 1] == 'o' && set[i - 2] == '-') {
                        secondSet[i] = '-';
                        secondSet[i - 1] = '-';
                        secondSet[i - 2] = 'o';
                        secondSet = pebbleChess(secondSet);
                        changed = true;
                    }
                }
                int firstAnswer = 0;
                int secondAnswer =0 ;
                for (int j = 0; j < secondSet.length; j++) {
                    if (firstSet[j] == 'o') {
                        firstAnswer++;
                    }
                    if (secondSet[j] == 'o') {
                        secondAnswer++;
                    }

                }
                if (firstAnswer<=secondAnswer && changed) {
                    if (firstAnswer<answer && firstAnswer!= 0){
                        answer = firstAnswer;
                        bestSet = firstSet;
                    }
                } else if (changed){
                    if (secondAnswer<answer && secondAnswer != 0){
                        answer = secondAnswer;
                        bestSet = secondSet;

                    }
                }
            }
        int num = 0;
        for (int i = 0; i <bestSet.length; i++) {
            if (bestSet[i] == 'o') {
                num++;
            }
        }
        if (num<answer) {
            answer = num;
        }
        return bestSet;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < cases; i++) {
            String line = scanner.nextLine();
            pebbleChess(line.toCharArray());
            System.out.println(answer);
            answer=12;
        }
    }
}
