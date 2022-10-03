import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        String string = scanner.nextLine();
        String[] array = string.split("\\s+");
        for (String s : array) {
            if (map.containsKey(s)) {
                System.out.print("no");
                return;
            } else {
                map.put(s, 1);
            }
        }
        System.out.print("yes");
    }

}

