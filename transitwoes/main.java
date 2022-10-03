import java.awt.*;
import java.util.Scanner;


public class main {


    public static void main(String[] args) {
        Scanner poo = new Scanner(System.in);
        int Time = poo.nextInt();
        int End = poo.nextInt();
        int N = poo.nextInt();
        int[] BusToBusTime = new int[N+1];

        for(var i = 0; i<N +1; i++) {
        BusToBusTime[i] = poo.nextInt();
        Time += N == i ? BusToBusTime[i] : 0;
        }
        for(var i = 0; i<N; i++) {
            Time += poo.nextInt();
        }
        for(var i =0; i<N; i++) {
            int BusWaitTime = poo.nextInt();
            Time += BusWaitTime>BusToBusTime[i] ? BusWaitTime : BusToBusTime[i];
        }
        System.out.println(Time <= End ? "yes" : "no");
    }
}
