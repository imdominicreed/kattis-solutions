import java.awt.*;
import java.util.Scanner;


public class main {


    public static void main(String[] args) {
        Scanner poo = new Scanner(System.in);
        int N = poo.nextInt();

        for(var i =0; i<N; i++) {
            double V = poo.nextDouble();
            double angle= Math.toRadians(poo.nextDouble());
            double distance = poo.nextDouble();
            double Height1 = poo.nextDouble()+1;
            double Height2 = poo.nextDouble()-1;
            double time =  (distance / (V * Math.cos(angle)));
            double RealHeight = (V * time * Math.sin(angle)) - (0.5 * 9.81 * Math.pow(time, 2));
            System.out.println((RealHeight<Height2 && RealHeight>Height1) ? "Safe" : "Not Safe");

        }
    }
}
