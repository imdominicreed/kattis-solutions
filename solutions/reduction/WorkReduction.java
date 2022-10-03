import java.util.ArrayList;
import java.util.Scanner;

public class WorkReduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Case " + (i+1));
            solve(scanner);
        }
    }
    static class Pair {
        String letter;
        int value;
        Pair(String l, int v) {
            letter = l;
            value = v;
        }
    }
    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < l; i++) {
            String line = scanner.next();
            int com = line.indexOf(',');
            int single = Integer.parseInt(line.substring(line.indexOf(':')+1,com));
            int half = Integer.parseInt((line.substring(com+1)));
            int best = Integer.MAX_VALUE;
            int work = n;
            int curr = 0;
            while(work >= m) {
                best = Math.min(best, curr + ((Math.max(0,work-m)*single)));
                work = work/2;
                curr += half;
            }
            pairs.add(new Pair(line.substring(0, line.indexOf(':')), best));
        }
        pairs.sort((o1,o2)->{
            if(Integer.compare(o1.value, o2.value) == 0) return o1.letter.compareTo(o2.letter);
            return Integer.compare(o1.value, o2.value);
        }
            );
        for(var p : pairs) {
            System.out.println(p.letter + " " + p.value);
        }
    }
}
