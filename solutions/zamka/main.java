
import java.awt.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int sum = 0;
        Scanner test = new Scanner(System.in);
        int L = test.nextInt();
        int D = test.nextInt();
        int X = test.nextInt();

        var poo = L;
        for (var a=L; a<D+1; a++){
            int length = Integer.toString(a).length();
            poo=a;
            for(var i=0;i<length;i++){
                sum = sum + poo % 10;
                poo = (poo - (poo % 10))/10;


            }
                if(sum == X){
                    System.out.println(a);
                    break;
                } else {
                    sum = 0;
                }
        }
        sum=0;
        for (var a=D;a>L-1; a--){
            int length = Integer.toString(a).length();
            poo=a;
            for(var i=0;i<length;i++){
                sum = sum + (poo % 10);
                poo = (poo - (poo%10))/10;


            }
            if(sum == X){
                System.out.println(a);
                break;
            } else {
                sum = 0;
            }
        }
    }
}
