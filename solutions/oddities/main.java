
    import java.util.Scanner;

    public class main {
        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            int N = test.nextInt();
            for(var i = 0; i<N; i++) {
                int H = test.nextInt();
                if(H % 2 == 0) {
                    System.out.println(H + " is even");
                } else {
                    System.out.println(H + " is odd");
            }

    }
        }
    }
