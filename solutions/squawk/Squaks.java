import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Squaks {
    static User[] users;
    static long numSquaksSent;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numUsers = scanner.nextInt();
        int numLinks = scanner.nextInt();
        int infected = scanner.nextInt();
        int endingTime = scanner.nextInt();
        if (numUsers == 1) {
            System.out.println(0);
            return;
        }
        users = new User[numUsers];
        for (int i = 0; i < numUsers; i++) {
            users[i] = new User(i);
        }
        for (int i = 0; i < numLinks; i++) {
            int user1 = scanner.nextInt();
            int user2 = scanner.nextInt();
            users[user1].add(users[user2]);
            users[user2].add(users[user1]);
        }
        users[infected].numSquaks = 1;
        int time =0;
        while(time != endingTime){
            numSquaksSent = 0;
            for(User user : users) {
                numSquaksSent += user.sendSquaks();
            }
            for (User user : users) {
                user.numSquaks = user.bufferedSquaks;
                user.bufferedSquaks =0;
            }
            time++;
        }
        System.out.println(numSquaksSent);
    }
}
class User extends HashSet<User> {
    public long numSquaks;
    public long bufferedSquaks;
    int code;
    User(int code) {
        this.code = code;
        bufferedSquaks =0;
    }

    public long sendSquaks(){
        long numSquaksSent = 0;
        for(User user: this) {
            user.addSquak(numSquaks);
            numSquaksSent += numSquaks;
        }
        return numSquaksSent;
    }
    private void addSquak(long n){
        bufferedSquaks+=n;
    }

    @Override
    public int hashCode() {
        return code;
    }
}
