import java.util.Scanner;
import java.util.TreeSet;

public class FlexibleSpaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int numRooms = scanner.nextInt();
        int[] rooms = new int[numRooms + 2];
        for (int i = 0; i < numRooms; i++) {
            rooms[i + 1] = scanner.nextInt();
        }
        rooms[numRooms + 1] = w;
        TreeSet<Integer> distinctSizes = new TreeSet<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = i+1; j < rooms.length; j++) {
                distinctSizes.add(rooms[j] - rooms[i]);
            }
        }
        for (int size: distinctSizes) {
            System.out.print(size + " ");
        }
    }
}
