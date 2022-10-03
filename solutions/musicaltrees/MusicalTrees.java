import java.util.Arrays;
import java.util.Scanner;

public class MusicalTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(m==1)  {
            System.out.println(n-1);
            return;
        }
        int[] p = new int[n];
        int[] t = new int[m];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            t[i] = scanner.nextInt();
        }
        Arrays.sort(p); Arrays.sort(t);
        boolean[] av = new boolean[m];
        int point = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (point+2 < m && t[point+1] < p[i]) point++;
            int num;
            if(Math.abs(p[i] - t[point]) <= Math.abs(p[i] - t[point+1])) num = point;
            else num = point+1;
            if(av[num]) ans++;
            av[num] = true;
        }
        System.out.println(ans);
    }
}
