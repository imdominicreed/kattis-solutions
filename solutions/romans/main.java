import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double miles = scanner.nextDouble();
        double floAns =  miles * (5280.0/4854.0) *1000;
        int ans= (int) ((floAns % 1) < 0.5 ? floAns : floAns + 1);
        System.out.println(ans);
    }
}

