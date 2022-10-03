import java.util.*;

public class XOREquations {
    public static int countQuestionMarks(String str) {
        int questionMarks = 0;
        for (char letter : str.toCharArray()) {
            if (letter == '?')
                questionMarks++;
        }
        return questionMarks;
    }

    static class Nums implements Comparable<Nums> {
        int q;
        String num;

        Nums(String num) {
            this.num = num;
            this.q = countQuestionMarks(num);
        }

        @Override
        public int compareTo(Nums o) {
            return q - o.q;
        }
    }

    public static LinkedList<Long> getList(String num, long currentNum, int index) {
        LinkedList<Long> currList = new LinkedList<>();
        for (int i = index; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                for (int j = (i == 0  && num.length() != 1) ? 1 : 0; j < 10; j++) {
                    currList.addAll(getList(num, currentNum * 10 + j, i + 1));
                }
                return currList;
            } else
                currentNum = currentNum *10 + num.charAt(i) - '0';
        }
        currList.add(currentNum);
        return currList;
    }
    static String largestNum;
    public static boolean isMatch(String num) {
        if (num.length() != largestNum.length())
            return false;
        for (int i = 0; i < largestNum.length(); i++) {
            if (largestNum.charAt(i) != '?' && num.charAt(i) != largestNum.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Nums[] nums = new Nums[3];
        nums[0] = new Nums(scanner.next());
        scanner.next();
        nums[1] = new Nums(scanner.next());
        scanner.next();
        nums[2] = new Nums(scanner.next());
        Arrays.sort(nums);
        LinkedList<Long> listOne = getList(nums[0].num, 0, 0);
        LinkedList<Long> listTwo = getList(nums[1].num, 0, 0);
        long answer = 0;
        largestNum = nums[2].num;
        for (long num1 : listOne) {
            for (long num2 : listTwo) {
                answer += isMatch(Long.toString(num1 ^ num2)) ? 1 : 0;
            }
        }

        System.out.println(answer);
    }
}