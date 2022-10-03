import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Yoda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String line2 = scanner.nextLine();
        int difference = line.length()-line2.length();
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        String answer1 = "";
        String answer2 = "";
        if(Math.signum(difference) == 1) {
            for (int i = 0; i < difference; i++) {
                nums2.add(-1);
            }
        }else if (Math.signum(difference) == -1) {
            for (int i = 0; i < Math.abs(difference); i++) {
                nums1.add(-1);
            }
            }
        for (int i = 0; i <line.length(); i++) {
            nums1.add(Character.getNumericValue(line.charAt(i)));
        }

        for (int i = 0; i <line2.length(); i++) {
            nums2.add(Character.getNumericValue(line2.charAt(i)));
        }
        for (int i = 0; i < nums1.size(); i++) {
            if (nums1.get(i) == nums2.get(i)) {
                answer1 += nums1.get(i);
                answer2 += nums2.get(i);
            } else if (nums1.get(i) > nums2.get(i)) {
                answer1 += nums1.get(i);
            } else {
                answer2 += nums2.get(i);
            }
        }
        if (answer1.isEmpty()) {
            System.out.println("YODA");
        }  else {
            System.out.println(Integer.parseInt(answer1));
        }
        if (answer2.isEmpty()) {
            System.out.println("YODA");
        }  else {
            System.out.println(Integer.parseInt(answer2));
        }

            }
        }


