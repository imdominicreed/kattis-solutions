import java.util.ArrayList;
import java.util.Scanner;

public class EatingOut {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numItems =  scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if(a+b+c<= 2*numItems){
            System.out.println("possible");
        } else{
            System.out.println("impossible");
        }
    }
}
