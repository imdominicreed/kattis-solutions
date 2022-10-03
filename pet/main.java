import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        int answer2 = 0;
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int a = 0; a < 4; a++) {
                sum += scanner.nextInt();
            }

            if(answer < sum){
                answer = sum;
                answer2=i+1;
            }
        }
        System.out.println(answer2 + " " +answer);

    }
}

