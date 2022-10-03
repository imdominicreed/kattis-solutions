import java.util.Scanner;

public class MethodicMultiplication {
    static int getNumS(String str) {
        int ans = 0;
        for(char let : str.toCharArray()) {
            ans += let == 'S' ? 1 : 0;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        int numS = getNumS(line1) * getNumS(line2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numS; i++) {
            sb.append("S(");
        }
        sb.append(0);
        for (int i = 0; i < numS; i++) {
            sb.append(")");
        }
        System.out.println(sb.toString());
    }
}
