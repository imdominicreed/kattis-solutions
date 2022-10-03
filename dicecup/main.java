
    import java.awt.*;
    import java.util.Scanner;

    public class main {
        public static int[] poo(int N, int M, int[] Array) {
            for(var i = 1; i<N+1; i++) {
                int sum =0;
                for(var a = 1; a<M+1; a++) {
                    sum=i+a;
                    Array[sum-1]++;

                }

            }
            return Array;
        }
        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            int N = test.nextInt();
            int M = test.nextInt();
            int max =0;
            int[] Array = new int[N+M];

            Array = poo(N,M, Array);





            for(var i =0; i<N+M; i++) {
                if(max < Array[i]) {
                    max = Array[i];

                }

            }
            for(var i =0; i<N+M; i++) {
                if(max == Array[i]) {

                    System.out.println(i+1);
                }

            }
        }
    }
