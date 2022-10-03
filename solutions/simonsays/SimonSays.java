import java.util.Scanner;

public class SimonSays {
    static boolean checkForSimonSays(String line) {
        String entry = "Simon says";
        if (line.length() < entry.length())
            return false;
        for (int j = 0; j < entry.length(); j++) {
            if (entry.charAt(j) != line.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (!checkForSimonSays(line))
                continue;
            for (int j = 10; j < line.length(); j++)
                ans.append(line.charAt(j));
            ans.append('\n');
        }
        System.out.print(ans.toString());
    }
}
