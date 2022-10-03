import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BankQueue {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Person implements Comparable<Person>{
        int money;
        int time;
        Person(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            return o.time-time;
        }
    }
    static class MoneyOrder implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o2.money-o1.money;
        }
    }
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        Person people[] = new Person[n];
        for (int i = 0; i < n; i++) {
            Person person = new Person(scanner.nextInt(), scanner.nextInt());
            people[i] = person;
        }
        Arrays.sort(people);
        PriorityQueue<Person> pq = new PriorityQueue<>(new MoneyOrder());
        int index = 0;
        long ans = 0;
        for (int i = t-1; i > -1; i--) {
            while (index != n && people[index].time == i) {
                pq.add(people[index]);
                index++;
            }
            if (!pq.isEmpty()) {
                ans += pq.poll().money;
            }
        }
        System.out.println(ans);
    }
}
