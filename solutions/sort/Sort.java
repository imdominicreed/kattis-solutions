import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt()-1;
        }
        Integer[] forLambda = arr.clone();
        Arrays.sort(arr, (o1, o2) -> {
            if(o1 .equals(o2)) return 0;
            int f1 = 0;
            int f2 = 0;
            int a1 = Integer.MAX_VALUE;
            int a2 = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if(forLambda[i].equals(o1)){
                    f1++;
                    a1 = Math.min(a1, i);
                }
                if(forLambda[i].equals(o2)){
                    f2++;
                    a2 = Math.min(a2, i);
                }
            }
            if(f2!=f1) return f2-f1;
            return a1-a2;
        });
        for(int num: arr) System.out.print(1+num + " ");
    }
}
