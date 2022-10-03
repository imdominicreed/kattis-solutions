
        import java.awt.*;
        import java.util.Scanner;

        public class main {


            public static void main(String[] args) {
                Scanner test = new Scanner(System.in);
                double sum = 0;
                int N = test.nextInt();
                double N2 = N;
                for(var i =0; i<N; i++) {
                    int a= test.nextInt();
                    if(a == -1) {
                       if(N2 !=0){
                           N2--;
                           
                       }


                    } else{
                        sum+=a;
                    }

                }
    double poo =sum / N2;
                System.out.println(poo);
            }

        }
