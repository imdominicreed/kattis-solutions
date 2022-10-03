import java.util.Scanner;

public class main {
    public static void Star(int i,int difference, int S) {
        int Row1 =0;
        int Row2 =0;
        int sum =0;
        int sum2 = 0;
        while(((sum != S) && sum<S) && ((sum2 != S) && sum2<S)) {
            Row1 += i;
            sum = Row1 + Row2;
            Row2 += i-difference;
            sum2 = Row1 + Row2;
        }
       if (S == sum || S == sum2) System.out.println(i + "," + (i-difference));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        System.out.println(S + ":");
        for(var i = 2; i<S; i++) {
            Star(i,1,S);
            Star(i,0,S);


        }
    }
}
