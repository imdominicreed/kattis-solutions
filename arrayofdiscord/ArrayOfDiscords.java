import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayOfDiscords {


    static boolean compareTwo(String num1, String num2) {
        return Long.parseLong(num1.substring(1)) > Long.parseLong(num2.substring(1));
    }
    static boolean checkArray(String arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            String a = arr[i];
            String b = arr[i + 1];
            if (a.length() == b.length()) {
                if (b.charAt(0) != '9' ) {
                    arr[i] = "9" + a.substring(1);
                    return true;
                }
                if (!a.equals("0") && (a.length() == 1 || a.charAt(0) > '1'  || compareTwo(a,b))) {
                    arr[i + 1] = b.length() == 1 ? "0" : 1 + b.substring(1);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        boolean changedOne = checkArray(arr);


        if (changedOne) {
            StringBuilder sb = new StringBuilder();
            for (String num : arr) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println("impossible");
        }
    }

}
