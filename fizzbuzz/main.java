
import java.awt.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int sum = 0;
        Scanner test = new Scanner(System.in);
        int X = test.nextInt();
        int Y = test.nextInt();
        int N = test.nextInt();
        for(var i =1; i<N+1; i++) {
            if(i % X ==0 && i % Y ==0) {
                System.out.println("FizzBuzz");
            } else  if (i % X == 0)  {
                System.out.println("Fizz");
            } else if (i % Y == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
