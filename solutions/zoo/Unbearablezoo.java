import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Unbearablezoo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int listCounter = 1;
        while(num != 0) {
            scanner.nextLine();
            TreeMap<String, Integer> animals = new TreeMap<>();
            for (int i = 0; i < num; i++) {
                String[] line = scanner.nextLine().split(" ");
                String key = line[line.length-1].toLowerCase();
                if (animals.containsKey(key)) {
                    animals.put(key, animals.get(key)+1);
                } else{
                    animals.put(key,1);
                }
            }
            System.out.println("List " + listCounter + ":");
            for (String animal : animals.keySet()) {
                System.out.println(animal + " | " + animals.get(animal));
            }
            listCounter++;
            num = scanner.nextInt();
        }
    }
}
