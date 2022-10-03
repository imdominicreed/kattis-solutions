
    import java.awt.*;
    import java.util.Scanner;

    public class main {
        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            int L = test.nextInt();
            int X = test.nextInt();
            int total = 0;
            int answer =0;
            for (var i = 0; i < X; i++) {
             String enter = test.next();
             int number = test.nextInt();

             if(enter.equals("enter")) {
                 total += number;
                 if (total>L) {
                     total-= number;
                     answer += 1;
                 }
             } else if(enter.equals("leave")) {
                 total-= number;
             }
            }
            System.out.println(answer);
        }
    }
