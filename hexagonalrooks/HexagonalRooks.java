import java.util.Scanner;

public class HexagonalRooks {
    static int row1;
    static int column1;
    static int row2;
    static int column2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coord1 = scanner.next();
        String coord2 = scanner.next();
        row1 = badParser(coord1);
        column1 = coord1.charAt(0) - 'a';
        row1 += column1 > 5 ? column1 - 5 : 0;
        row2 = badParser(coord2);
        column2 = coord2.charAt(0) - 'a';
        row2 += column2 > 5 ? column2 - 5 : 0;
        int ans = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = Math.max(i - 5, 0); j < Math.min(i + 6, 11); j++) {
                if (canReach(i, j, row2, column2) && canReach(i, j, row1, column1))
                    ans++;
            }
        }
        System.out.println(ans);
    }
    static int badParser(String str) {
        char firstDigit = str.charAt(str.length() - 1);
        if (str.length() == 3)
            return 9 + (firstDigit - '0');
        return firstDigit - '1';
    }
    static boolean canReach(int col, int row, int row2, int column2) {
        if (col == column2 && row == row2)
            return false;
        return col == column2 || row == row2 || row - row2 == col - column2;
    }
}