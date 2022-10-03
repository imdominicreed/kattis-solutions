import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StickySituation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long nums[] = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                if (nums[i] + nums[j] > nums[j+1]) {
                    System.out.println("possible");
                    return;
                }
            }
        }
        System.out.print("impossible");
    }
}
