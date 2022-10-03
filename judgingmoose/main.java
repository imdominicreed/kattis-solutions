 import java.awt.*;
    import java.util.Scanner;

    public class main {
        public static void poo(int a, int b) {
            if(a>b) {
                System.out.println("Odd " + 2 * a);
            }
        }

        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            int L = test.nextInt();
            int R = test.nextInt();
                if(L ==0 && 0 == R) {
                    System.out.println("Not a moose");
                }  else if (L==R) {
                    System.out.println("Even " + 2*L);
                }
                poo(L,R);
                poo(R,L);

        }
    }
