import java.awt.*;
import java.util.Scanner;


public class main {


    public static void main(String[] args) {
        Scanner poo = new Scanner(System.in);
            int h = poo.nextInt();
            int m =poo.nextInt();
            int h2 = h == 0 ? 23 : h-1;
            System.out.println(m< 45 ? h2 + " " + (60-(45-m)) : h + " " +(m-45));
    }
}
