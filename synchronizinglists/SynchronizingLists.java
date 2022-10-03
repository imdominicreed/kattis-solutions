import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class SynchronizingLists {
    public static void main(String[] args) {
        TreeSet<Integer> secondList = new TreeSet<>();
        TreeMap<Integer, Integer> orderedFirstList = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int listLength = scanner.nextInt();
        while (listLength != 0) {
            secondList.clear();
            orderedFirstList.clear();
            int[] answer = new int[listLength];
            for (int i = 0; i < listLength; i++) {
                orderedFirstList.put(scanner.nextInt(), i);
            }
            for (int i = 0; i < listLength; i++) {
                secondList.add(scanner.nextInt());
            }
            for (int num : orderedFirstList.keySet()) {
                answer[orderedFirstList.get(num)] = secondList.pollFirst();
            }
            for (int i = 0; i < answer.length; i++) {
                System.out.println(answer[i]);
            }
            listLength = scanner.nextInt();
            if (listLength == 0) {
                break;
            }
            System.out.println();

        }
    }
}
