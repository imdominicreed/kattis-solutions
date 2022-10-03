import java.time.LocalTime;
import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String letters = scanner.nextLine();
        int answer =0;int sum = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(var i =0; i<letters.length(); i++) {
            char key = letters.charAt(i);
            map.put(key, map.containsKey(key) ? map.get(key) + 1: 1);
            sum = map.get(key);
        }

        for (char letter: map.keySet()) {
               if(map.size() == 3) {
                   sum = sum < map.get(letter) ? sum : map.get(letter);
               } else {
                   sum = 0;
               }
               answer += Math.pow(map.get(letter),2);
        }
        sum*=7;
        System.out.println(answer+sum);
    }
}

