import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class judging {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        long cases = scanner.nextInt();
        scanner.nextLine();
        long answer = 0;
        for (long i = 0; i < cases; i++) {
            String line = scanner.nextLine();
            map1.putIfAbsent(line, 0);
            map1.put(line, map1.get(line)+1);
        }
        for (long i = 0; i < cases; i++) {
            String line = scanner.nextLine();
            map2.putIfAbsent(line, 0);
            map2.put(line, map2.get(line)+1);
        }
        for (String key1: map1.keySet()) {
            if (map2.containsKey(key1)) {
                answer+=Math.min(map1.get(key1),map2.get(key1));
            }
        }
        System.out.println(answer);
    }
}
