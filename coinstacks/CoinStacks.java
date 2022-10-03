import java.util.PriorityQueue;
import java.util.Scanner;

public class CoinStacks {
    static class Pair implements Comparable<Pair> {
        int index;
        int stack;

        Pair(int index, int stack) {
            this.index = index;
            this.stack = stack;
        }

        @Override
        public int compareTo(Pair o) {
            return o.stack - this.stack;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>(n);
        int coins = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            coins += num;
            if (num != 0) {
                pq.add(new Pair(i, num));
            }
        }
        if (coins == 0) {
            System.out.println("yes");
            return;
        }
        if (coins % 2 != 0) {
            System.out.println("no");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            try {
                Pair a = pq.poll();
                Pair b = pq.poll();
                sb.append(a.index + 1).append(" ").append(b.index + 1).append('\n');
                a.stack--;
                b.stack--;
                if(b.stack != 0)
                    pq.add(b);
                if (a.stack != 0) {
                    pq.add(a);
                }
            } catch (NullPointerException e){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
        System.out.println(sb.toString());
    }
}
