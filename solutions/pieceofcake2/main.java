
import java.util.Scanner;

public class main {
     static int poo(int a,int b) {
        if(a<b-a) {

            return (b-a);
        }
        return a;
    }
    public static void main(String[] args) {

        Scanner test = new Scanner(System.in);
        int N = test.nextInt();
        int H = test.nextInt();
        int V = test.nextInt();
H=poo(H,N);
V =poo(V,N);
System.out.println(4*H*V);
}
    }
