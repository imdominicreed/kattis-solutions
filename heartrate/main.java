
    import java.awt.*;
    import java.util.Scanner;

    public class main {
        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            int N = test.nextInt();

            for (var i = 0; i < N; i++) {
                int B = test.nextInt();
                double P  = test.nextDouble();
                double BPM = (60 * B)/P;
                System.out.println(BPM-(BPM/B));
                System.out.println(BPM);
                System.out.println(BPM+(BPM/B));
            }
        }
    }
