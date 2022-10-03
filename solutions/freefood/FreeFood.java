import java.util.HashSet;
import java.util.Scanner;

public class FreeFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int events = scanner.nextInt();
        HashSet<Integer> days = new HashSet<>();
        for (int i = 0; i < events; i++) {
            int starting = scanner.nextInt();
            int ending = scanner.nextInt();
            for (int j =starting; j < ending+1; j++) {
                    days.add(j);
            }
        }
        System.out.println(days.size());
    }
}
