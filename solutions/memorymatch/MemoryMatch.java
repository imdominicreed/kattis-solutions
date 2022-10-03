import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MemoryMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        HashMap<String, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < c; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String as = scanner.next();
            String bs = scanner.next();
            if(as.equals(bs)) {
                n-= 2;
                map.remove(as);
                continue;
            }
            map.putIfAbsent(as, new HashSet<>());
            map.putIfAbsent(bs, new HashSet<>());
            map.get(as).add(a);
            map.get(bs).add(b);
        }
        int ans = 0;
        int remaining = 0;
        for(var a : map.values()) {
            if(a.size() == 2) {
                ans++;
                n -= 2;
            } else {
                n -= 1;
                remaining++;
            }
        }
        if(remaining == n) {
            ans += remaining;
        } else if(n== 2) {
            ans++;
        }
        System.out.print(ans);
    }
}
