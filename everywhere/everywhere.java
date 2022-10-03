import java.util.HashSet;
import java.util.Scanner;

public class everywhere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int cities = scanner.nextInt();
            scanner.nextLine();
            HashSet<String> list = new HashSet<>();
            for (int j = 0; j < cities; j++) {
                list.add(scanner.nextLine());
            }
            System.out.println(list.size());
        }
    }
}
