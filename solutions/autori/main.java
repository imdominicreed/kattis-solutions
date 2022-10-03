
import java.awt.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        String A = test.nextLine();
        var answer = A.substring(0,1);
        var c =A.length();
        for(var i = 0; i < c; i++) {
           var g = A.indexOf("-");
           if(g == -1) {
                i = c+1;
            } else {
               answer = answer + A.substring(g + 1, g + 2);
               A = A.substring(g + 1, A.length());


           }

        }
        System.out.println(answer);
    }
}
