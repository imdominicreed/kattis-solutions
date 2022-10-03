import java.util.Scanner;

public class Sumdoku {
    static char[][] comp_row;
    static char[][] comp_column;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        comp_row = new char[9][6];
        comp_column = new char[6][9];
        int coli = 0;
        int rowi = 0;
        for (int i = 0; i < 15; i++) {
            String line = scanner.nextLine();
            if (line.length() == 6) {
                for (int j = 0; j < line.length(); j++) {
                    comp_row[rowi][j] = line.charAt(j);
                }
                rowi++;
            } else {
                for (int j = 0; j < line.length(); j++) {
                    comp_column[coli][j] = line.charAt(j);
                }
                coli++;
            }
        }
        int grid[][] = new int[9][9];
        grid(grid, new boolean[9][10], new boolean[9][10], new boolean[9][10], 0, 0, 0, 0, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(grid[i][j]);
                if (j != 8)
                    sb.append(' ');
            }
            if (i != 8)
                sb.append('\n');
        }
        System.out.print(sb.toString());
    }


    public static boolean grid(int[][] grid, boolean col[][], boolean row[][], boolean[][] box, int x, int y, int rowX, int rowY, int columnX, int columnY) {
        if (columnY == 9) {
            columnX++;
            columnY = 0;
        }
        if (rowY == 6) {
            rowX++;
            rowY = 0;
        }
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9)
            return true;
        int min = 1;
        int max = 9;
        if (((y) % 3 != 0)) {
            int prev = 10 - grid[x][y - 1];
            switch (comp_row[rowX][rowY]) {
                case '<':
                    max = Math.min(max, prev - 1);
                    break;
                case '>':
                    min = Math.max(min, prev + 1);
                    break;
                case '=':
                    max = Math.min(max, prev);
                    min = Math.max(min, prev);
                    break;
            }
        }
        if (((x) % 3 != 0)) {
            int prev = 10 - grid[x - 1][y];
            switch (comp_column[columnX][columnY]) {
                case '<':
                    max = Math.min(max, prev - 1);
                    break;
                case '>':
                    min = Math.max(min, prev + 1);
                    break;
                case '=':
                    max = Math.min(max, prev);
                    min = Math.max(min, prev);
                    break;
            }
        }
        for (int i = min; i <= max; i++) {
            grid[x][y] = i;
            if (box[(x / 3 * 3) + y / 3][i] || col[y][i] || row[x][i])
                continue;
            box[(x / 3 * 3) + (y) / 3][i] = col[y][i] = row[x][i] = true;
            if (grid(grid, col, row, box, x, y + 1, rowX, y % 3 == 0 ? rowY : rowY + 1, columnX, x % 3 == 0 % 3 ? columnY : columnY + 1)) {
                return true;
            }
            box[(x / 3 * 3) + (y) / 3][i] = col[y][i] = row[x][i] = false;
        }
        return false;
    }
}
