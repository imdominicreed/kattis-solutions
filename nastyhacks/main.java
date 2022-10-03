
    import java.awt.*;
    import java.util.Scanner;

    public class main {
        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            int N = test.nextInt();
            for(var i = 0; i<N; i++) {
                int r = test.nextInt();
                int e = test.nextInt();
                int c = test.nextInt();
                if (r > e - c) {
                    System.out.println("do not advertise");
                } else if (r < e - c) {
                    System.out.println("advertise");
                } else {
                    System.out.println("does not matter");
                }


    }
        }
    }
