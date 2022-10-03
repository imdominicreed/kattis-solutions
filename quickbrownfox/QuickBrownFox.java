import java.util.Scanner;

public class QuickBrownFox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <n; i++) {
            char[] line = scanner.nextLine().toCharArray();
            boolean[] occ = new boolean[26];
            int a = 26;
            for(var b : line) {
                try {
                    b = Character.toLowerCase(b);
                    if (!occ[b-'a']) a--;
                    occ[b-'a'] = true;
                } catch (Exception e) {}
            }
            if (a == 0) System.out.println("pangram");
            else {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if(!occ[j]) sb.append((char)('a'+j));
                }
                System.out.println("missing " + sb );
            }
        }
    }
}
