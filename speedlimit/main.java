import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       for(var i = 0; i<10; i++){
           int n = scanner.nextInt();
           int prevT=0;
           int miles =0;
           if(n==-1) break;
           for(var a =0; a<n; a++) {
               int s = scanner.nextInt(); int t = scanner.nextInt();
               miles +=s*(t-prevT);
               prevT=t;
           }
           System.out.println(miles + " miles");
       }
    }
}
