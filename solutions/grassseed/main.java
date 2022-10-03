
    import java.awt.*;
    import java.util.Scanner;

    public class main {

        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            double C = test.nextDouble();
            int L = test.nextInt();
            double sum =0;
            for (var i =0; i<L; i++) {
                 sum += test.nextDouble()*test.nextDouble();
            }
            System.out.println(sum*C);
        }
    }
