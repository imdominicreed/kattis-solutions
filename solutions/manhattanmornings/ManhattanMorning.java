import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ManhattanMorning {
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        boolean increasing;

        Pair(int x, int y, boolean increasing) {
            this.x = x;
            this.y = y;
            this.increasing = increasing;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Pair pair) {
            if (x == pair.x) {
                if (increasing) {
                    return y - pair.y;
                } else {
                    return pair.y-y;
                }
            }
            return x - pair.x;
        }
    }

    static int x0;
    static int x1;
    static int y0;
    static int y1;

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        String[] a = scanner.readLine().split(" ");
        boolean increasing;
        increasing = Integer.parseInt(a[1]) <= Integer.parseInt(a[3]) == Integer.parseInt(a[0]) <= Integer.parseInt(a[2]);
        x0 = Math.min(Integer.parseInt(a[0]), Integer.parseInt(a[2]));
        x1 = Math.max(Integer.parseInt(a[0]), Integer.parseInt(a[2]));
        y0 = Math.min(Integer.parseInt(a[1]), Integer.parseInt(a[3]));
        y1 = Math.max(Integer.parseInt(a[1]), Integer.parseInt(a[3]));
        Pair[] cords = new Pair[n];
        for (int i = 0; i < n; i++) {
            a = scanner.readLine().split(" ");
            cords[i] = new Pair(Integer.parseInt(a[0]), Integer.parseInt(a[1]), increasing);
        }
        int ans;
        Arrays.sort(cords);
        if (increasing) {

            ans = lengthOfLIS(cords);
        }

         else
            ans = LDS(cords);

        System.out.println(ans);

    }
    public static int LDS(Pair[] A)
    {
        // array to store sub-problem solution. L[i] stores the length
        // of the longest decreasing subsequence ends with A[i]
        int[] L = new int[A.length];

        // longest decreasing subsequence ending with A[0] has length 1
        L[0] = 1;

        // start from second element in the array
        for (int i = 1; i < A.length; i++)
        {
            if (A[i].x > x1 || A[i].x < x0 || A[i].y > y1 || A[i].y < y0)
                continue;
            // do for each element in subarray A[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find longest decreasing subsequence that ends with A[j]
                // where A[j] is more than the current element A[i]
                if (A[j].x > x1 || A[j].x < x0 || A[j].y > y1 || A[j].y < y0)
                    continue;
                if (A[j].y >= A[i].y && L[j] > L[i]) {
                    L[i] = L[j];
                }
            }

            // include A[i] in LDS
            L[i]++;
        }

        // return longest decreasing subsequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
    }
    public static int lengthOfDIS(Pair[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (Pair a : nums) {
            if (a.x > x1 || a.x < x0 || a.y > y1 || a.y < y0)
                continue;
            int x = a.y;
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] >= x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                size++;
        }
        return size;
    }
    public static int lengthOfLIS(Pair[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (Pair a : nums) {
            if (a.x > x1 || a.x < x0 || a.y > y1 || a.y < y0)
                continue;
            int x = a.y;
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] <= x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                size++;
        }
        return size;
    }
}
