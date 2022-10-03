import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double h = scanner.nextDouble();
        Double v = scanner.nextDouble();
        System.out.print( (int) (h*(1/(Math.sin(Math.toRadians(v)))))+1);
    }
}

