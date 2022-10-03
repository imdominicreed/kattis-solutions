import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>();
      for(var i = 0; i< 10;i++) {
          map.putIfAbsent(scanner.nextInt()%42, 1);
      }
      System.out.println(map.size());
    }
}

