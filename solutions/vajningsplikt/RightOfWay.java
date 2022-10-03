import java.util.Scanner;

public class RightOfWay {
    public static String findopposite(String direction){
        String opposite;
        if (direction.equals("North")) {
            opposite = "South";
        } else if(direction.equals("South")) {
            opposite = "North";
        } else if(direction.equals("East")) {
            opposite = "West";
        } else {
            opposite = "East";
        }
        return opposite;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String car1 = scanner.next();
        String direction = scanner.next();
        String car1OP = findopposite(car1);
        String opposite= findopposite(direction);
        String car2 = scanner.next();
        if (car1.equals("North") && direction.equals("East") || (car1.equals("East") && direction.equals("South")) || (car1.equals("South") && direction.equals("West")) || car1.equals("West") && direction.equals("North")) {
            if (opposite.equals(car2) || car1OP.equals(car2)) {
                System.out.println("Yes");
                return;
            }
        } else if (direction.equals(car1OP)) {
            if ((direction.equals("North") && car2.equals("East")) || ((direction.equals("South") && car2.equals("West"))|| (direction.equals("East") && car2.equals("South") || (direction.equals("West") && car2.equals("North"))))) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
