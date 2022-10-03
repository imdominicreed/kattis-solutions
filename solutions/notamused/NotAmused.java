import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class NotAmused {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Long> map = new TreeMap<>();
        HashMap<String, Long> in = new HashMap<>();
        int i = 1;
        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            if (line[0].equals("OPEN"))
                map = new TreeMap<>();
            else if (line[0].equals("CLOSE")) {
                printMap(i, map);
                i++;
            } else if(line[0].equals("ENTER")) {
                in.put(line[1], Long.parseLong(line[2]));
            } else {
                long sum = Long.parseLong(line[2]) - in.get(line[1]);
                if (map.containsKey(line[1])) {
                    sum += map.get(line[1]);
                    map.remove(line[1]);
                }
                map.putIfAbsent(line[1], sum);
            }
        }
    }
    static void printMap(int i, TreeMap<String, Long> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("Day ").append(i).append("\n");
        for(String key : map.keySet()) {
            long num = map.get(key);
            sb.append(key).append(" $").append(num / 10).append(".").append(num % 10 == 0 ? ("00") : num % 10 *10).append('\n');
        }
        System.out.print(sb.toString());
    }
}
