import java.util.Scanner;

public class Exams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int right = scanner.nextInt();
        String l1 = scanner.next();
        String l2 = scanner.next();
        int ans = 0;
        int same = 0;
        int diff = 0;
        for (int i = 0; i < l1.length(); i++) {
            if (l1.charAt(i) == l2.charAt(i)) {
                same++;
            } else  {
                diff++;
            }
        }
        ans += Math.min(same, right);
        ans += Math.min(l1.length()-right, diff);
        System.out.println(ans);
    }
}
