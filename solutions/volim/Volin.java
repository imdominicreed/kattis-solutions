import java.util.Scanner;

public class Volin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt()-1;
        int timeRemaining = 210;
        int questions =  scanner.nextInt();
        for (int i = 0; i < questions; i++) {
            timeRemaining -= scanner.nextInt();
            if(timeRemaining <= 0)
                break;

            String result = scanner.next();
            if (result.equals("T"))
                start = ((start+1) % 8) ;
        }
        System.out.println(start+1);
    }
}
