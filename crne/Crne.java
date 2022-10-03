import java.util.Scanner;

public class Crne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCuts = scanner.nextInt();
        if (numCuts % 2 == 0) {
            long vertical =(numCuts / 2) +1;
            System.out.println(vertical*vertical);
        } else {
            long vertical =(numCuts / 2) +2;
            long horizontal = (numCuts/2)+1;
            System.out.println(vertical*horizontal);
        }
    }
}
