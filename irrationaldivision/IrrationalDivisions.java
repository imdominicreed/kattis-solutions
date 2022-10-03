import java.util.Scanner;

public class IrrationalDivisions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        if (h%2 == 1 && w%2 == 1) {
            System.out.println(1);
        } else if(h%2 == 0) {
            System.out.println(0);
        } else if(w>h) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }
}
