import java.util.Scanner;

public class BattleSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        boolean r = false;
        boolean b = false;
        boolean l = false;
        StringBuilder mainString = new StringBuilder();
        StringBuilder holder = new StringBuilder();
        boolean[] combos = new boolean[line.length()];
        for (int i = 0; i < combos.length-2; i++) {
            for (int j = 0; j < 3; j++) {
                switch (line.charAt(i+j)) {
                    case 'R':
                       r = true;
                       break;
                    case 'B':
                       b = true;
                        break;
                    case 'L':
                       l = true;
                       break;
                }
            }
            if (r && b && l) {
                combos[i] = true;
                combos[i+1] = true;
                combos[i+2] = true;
                i += 2;
            }
            r = false;
            b = false;
            l = false;
        }
        for (int i = 0; i < line.length(); i++) {
            if (combos[i]) {
                mainString.append('C');
                i += 2;
                continue;
            }
            char letter = line.charAt(i);
            switch (letter) {
                case 'R':
                    mainString.append('S');
                    break;
                case 'B':
                    mainString.append('K');
                    break;
                case 'L':
                    mainString.append('H');
            }
        }
        mainString.append(holder);
        System.out.println(mainString.toString());
    }
}
