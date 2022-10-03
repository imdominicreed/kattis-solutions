import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        Calendar test = Calendar.getInstance();
        test.set(2009, month-1,day);
        System.out.print(test.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.ENGLISH));
    }

}

