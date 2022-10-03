
        import java.awt.*;
        import java.util.Scanner;

        public class main {
            public static int poo(int a, int b, int c) {
                if(a==b){
                    return c;
                } else if ( b==c) {
                    return a;
                } else {
                    return b;
                }
            }
            public static void main(String[] args) {
                Scanner test = new Scanner(System.in);
                int A = test.nextInt();
                int a = test.nextInt();
                int B = test.nextInt();
                int b = test.nextInt();
                int C = test.nextInt();
                int c = test.nextInt();
                System.out.println(poo(A, B, C) + " " + poo(a,b,c));
            }
        }
