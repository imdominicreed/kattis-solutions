
        import java.awt.*;
        import java.util.Scanner;

        public class main {
            public static int poo(String a, int c) {
                int[] dom = {0, 0, 14, 10, 20, 3, 4, 11};
                int[] ndom = {0,0,0,10,2,3,4,11};
                String[] letters = {"7","8","9","T","J","Q","K","A"};
                for(var i =0; i<8; i++) {
                    if(a.equals(letters[i])) {
                        if(c == 1){
                            return dom[i];
                        } else {
                            return ndom[i];
                        }
                    }

                }
                return 100000000;
            }
            public static void main(String[] args) {
                Scanner test = new Scanner(System.in);
                int sum=0;
                int N = 4 * test.nextInt();
                var s = test.nextLine();
                s=s.substring(s.length()-1,s.length());
        
                for(var i =0; i<N; i++) {
                    var letters = test.nextLine();
                    if(letters.substring(1,2).equals(s)) {
                       sum += poo(letters.substring(0,1),1);
                       
                    } else {
                       sum+= poo(letters.substring(0,1),0);
                       
                    }
                }
                System.out.println(sum);
            }
        }
