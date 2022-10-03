import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class main {

   public static Character[][] changer(Character[][] array, int x , int y) {
      HashMap<Boolean, Integer> map = new HashMap<>();
      map.put(true, 0);
      array[x][y] = 'F';
      // left
      if(x-1 != -1 && array[x-1][y] == '-') {
         array[x-1][y] = '+';
         changer(array, x-1, y);
      } else {
         map.put(true, map.get(true));
      }
      // right
      if (x+1 != array.length && array[x+1][y] == '-') {
         array[x+1][y] = '+';
         changer(array, x+1, y);
      }else {
         map.put(true, map.get(true));
      }
      // bottom
      if (y-1 != -1 && array[x][y-1] == '-') {
         array[x][y-1] = '+';
         changer(array, x, y-1);
      } else {
         map.put(true, map.get(true));
      }
      // top
      if (y+1 != array[0].length && array[x][y+1] == '-') {
         array[x][y+1] = '+';
         changer(array, x, y+1);
      }else {
         map.put(true, map.get(true));
      }
      if(map.get(true) == 0 ){
         return array;
      }
      changer(array, x, y);
      return array;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int counter = 0;
      while(scanner.hasNext()) {
         int m = scanner.nextInt();
         int n = scanner.nextInt();
         scanner.nextLine();
         int answer = 0;
         Character[][] array = new Character[m][n];
         for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
               array[i][j] = line.charAt(j);
            }
         }
         for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
               if (array[x][y] == '-') {
                  answer++;
                  array = changer(array, x, y);

               }
            }
         }
         counter++;
         System.out.println("Case " + counter + ": " + answer);
      }
   }
}