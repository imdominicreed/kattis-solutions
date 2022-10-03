import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SavingDaylight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " " + scanner.next() + " " + scanner.next() + " ");
            String end = scanner.next();
            String start = scanner.next();
            LocalDateTime timedate = getDuration(start).minusHours(Integer.parseInt(end.split(":")[0])).minusMinutes(Integer.parseInt(end.split(":")[1]));
            System.out.print(timedate.getHour() + " hours " + timedate.getMinute() + " minutes\n");
        }
    }
    static LocalDateTime  getDuration(String time) {
        return LocalDateTime.of(1,1,1,  Integer.parseInt(time.split(":")[0]),  Integer.parseInt(time.split(":")[1]), 0);
    }
}
