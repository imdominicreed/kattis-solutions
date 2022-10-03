import java.util.*;

public class main {
    public static int finder(int poo, int answer){
        return poo-(answer/2)*2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String num = scanner.nextLine();
            int a =0;
            for (int j = 0; j < 4; j++) {
                a = j >= 2 ? 1 : a;
                if (num.charAt(j) == '0') {
                    map.putIfAbsent(a, 0);
                    map.put(a, map.get(a) + 1);
                }
            }
        }
        int answer =  map.get(0) > map.get(1) ? map.get(1) : map.get(0);
        System.out.print(answer/2 + " " + finder(map.get(0), answer) + " " + finder(map.get(1), answer));
    }

}

