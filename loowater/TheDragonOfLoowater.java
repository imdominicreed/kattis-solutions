import java.lang.reflect.Array;
import java.util.*;

public class TheDragonOfLoowater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int dragonHeads = scanner.nextInt();
            int Knights = scanner.nextInt();
            if (dragonHeads == 0 & Knights ==0)
                return;
            int[] dragonHeights = new int[dragonHeads];
            int[] knights = new int[Knights];
            for (int i = 0; i < dragonHeads; i++) {
                dragonHeights[i]= scanner.nextInt();
            }
            for (int i = 0; i < Knights; i++) {
                knights[i] = scanner.nextInt();
            }
            Arrays.sort(dragonHeights);
            Arrays.sort(knights);
            int answer = 0;
            boolean satisfied = false;
            boolean failure = false;
            int index =0;
           for(int i = 0; i < dragonHeights.length; i++) {
               for (int j = index; j < knights.length; j++) {
                    int height = knights[j];
                    if (height >= dragonHeights[i]) {
                        satisfied = true;
                        answer += height;
                        index = j+1;
                        break;
                    }
                }
                if (!satisfied) {
                    System.out.println("Loowater is doomed!");
                    failure = true;
                    break;
                } else{
                    satisfied = false;
                }

            }
            if (!failure) {
                System.out.println(answer);
            }
        }

    }
}
