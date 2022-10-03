import java.util.Arrays;
import java.util.Scanner;

public class AsciiFiguration {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        boolean first = false;
        while(solve(first, scanner)) {
            first = true;
        }
    }
    public static char swap(char letter) {
        if(letter == '|') return '-';
        if(letter == '-') return '|';
        return letter;
    }
    public static boolean solve(boolean print, Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        if(n == 0) return false;
        if(print) System.out.println();
        char[][] grid = new char[n][];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            grid[i] = scanner.nextLine().toCharArray();
            max = Math.max(max, grid[i].length);
        }
        char[][] rotated = new char[max][n];
        for(int i = 0; i < max; i++) Arrays.fill(rotated[i], ' ');
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                rotated[j][n-1-i] = swap(grid[i][j]);
            }
        }
        for(int i = 0; i < max; i++) {
            int last = 0;
            for(int j = 0; j < n; j++) 
                if(rotated[i][j] != ' ') last = Math.max(j, last);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= last; j++) sb.append(rotated[i][j]);
            System.out.println(sb);
        }
        return true;
    }
    
}
