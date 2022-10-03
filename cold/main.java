
        import java.awt.*;
        import java.util.Scanner;

        public class main {
            public static void main(String[] args) {

                Scanner test = new Scanner(System.in);
                int N = test.nextInt();
                int sum=0;
                for(var i = 0; i<N; i++) {
                    if(0>test.nextInt()){
                        sum++;
                    }
                    
                }
                System.out.println(sum);
            }
        }
