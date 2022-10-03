import java.util.Scanner;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner.next());
        }
    }
    public static void solve(String s) {
        StringBuilder ans = new StringBuilder();
        int skip = (int) Math.ceil(Math.sqrt(s.length()));
        for (int i = 0; i < skip; i++) {
            StringBuilder rev = new StringBuilder();
            int pt = i;
            while (pt < s.length()) {
                rev.append(s.charAt(pt));
                pt += skip;
            }
            ans.append(rev.reverse());
        }
        System.out.println(ans.toString());
    }
}
