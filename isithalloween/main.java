
    import java.awt.*;
    import java.util.Scanner;

    public class main {
        public static void main(String[] args) {

            Scanner test = new Scanner(System.in);
            var M = test.nextLine();

            if(M.equals("OCT 31") || M.equals("DEC 25")) {
                            System.out.println("yup");
            } else {
                System.out.println("nope");
            }
        }
    }
