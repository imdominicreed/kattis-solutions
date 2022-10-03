import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Treemap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        scanner.nextLine();
        while(n != 0) {
            TreeMap<String, TreeSet<String>> map = new TreeMap<>();
            for(int j = 0;  j<n; j++) {
                String line = scanner.nextLine();
                String[] spl = line.split(" ");
                String name = spl[0];
                for (int i = 1; i < spl.length; i++) {
                    String food = spl[i];
                    map.putIfAbsent(food, new TreeSet<>());
                    map.get(food).add(name);
                }
            }
            for(String food: map.keySet()) {
                System.out.print(food + " ");
                for (String name : map.get(food)) {
                    System.out.print(name + " ");
                }
                System.out.println();
            }
            System.out.println();
            n  = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
