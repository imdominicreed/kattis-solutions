import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DoublePlusGood {
    static HashSet<Long> possibities;
    static String[] stringNums;

    public static void calcPerm(int index, String type, ArrayList<String> nums) {
        if (index == stringNums.length) {
            long sum =0;
            for (String numb : nums) {
                sum += Long.parseLong(numb);
            }
            possibities.add(sum);
            return;
        }
        ArrayList<String> clone = (ArrayList<String>) nums.clone();
            String element = clone.get(clone.size() - 1);
            clone.remove(clone.size() - 1);
            clone.add(element + stringNums[index]);
            calcPerm(index + 1, type + "+", clone);

        clone = (ArrayList<String>) nums.clone();
        clone.add(stringNums[index]);
        calcPerm(index + 1, type + "_", clone);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        stringNums = line.split("\\+");
        possibities = new HashSet<>();
        ArrayList<String> empty = new ArrayList<>();
        empty.add(stringNums[0]);
        calcPerm(1, "", empty);
        System.out.println(possibities.size());
    }
}
