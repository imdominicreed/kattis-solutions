import java.util.BitSet;
import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int k = scanner.nextInt();
        BitSet register = new BitSet();
        register.set(r);
        BitSet office = new BitSet();
        office.set(k);
        int distanceTraveled = 1;
        boolean visitedOffice = false;
        boolean visitedRegister = false;
        BitSet mask = new BitSet();
        mask.set(1);
        int index = 1;
        while (!visitedOffice || !visitedRegister || !mask.get(1)) {
            mask.and(office);
            if (mask.get(index))
                visitedOffice = true;
            else
                mask.set(index);
            if (distanceTraveled >= n) {
                mask.and(register);
                if (mask.get(index))
                    visitedRegister = true;
                else
                    mask.set(index);
            }
            if (visitedOffice && visitedRegister) {
                index--;
            } else if (visitedOffice) {
                if (index < r) {
                    index++;
                } else {
                    index--;
                }
            } else {
                index++;
            }
            mask.clear();
            mask.set(index);
            distanceTraveled++;
        }
        System.out.println(distanceTraveled+1);
    }
}
