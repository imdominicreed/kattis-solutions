
    import java.awt.*;
    import java.util.Scanner;

    public class main {
        public static int poo(int a) {
            int holder = 0;
            int answer =0;
            for (var i = 0; i < 3; i++) {
                holder = a % 10;
                a=(a-holder)/10;
                answer+= holder*Math.pow(10,2-i);
            }
            return answer;
        }

        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            int A = poo(test.nextInt());
            int B = poo(test.nextInt());
            if(A>B) {
            System.out.println(A);
            } else {
           System.out.println(B);
            }
        }
    }
