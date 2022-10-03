import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class CompoundWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        TreeSet<String> words = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j)
                    continue;
                words.add(list.get(i) + list.get(j));
            }
        }
        for(String word : words)
            System.out.println(word);
    }
}
