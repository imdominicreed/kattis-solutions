import java.util.*;

public class AClassyProblem {
    static class Person implements Comparable<Person>{
        String name;
        ArrayList<Integer> c;
        Person(String name, String c) {
            this.name = name;
            this.c = new ArrayList<>();
            List<String> rev = Arrays.asList(c.split("-"));
            Collections.reverse(rev);
            for(String t : rev)
                switch (t) {
                    case "upper":
                        this.c.add(2);
                        break;
                    case "middle":
                        this.c.add(1);
                        break;
                    default:
                        this.c.add(0);
                }
            for (int i = 0; i <10 ; i++) {
                this.c.add(1);
            }
        }

        @Override
        public int compareTo(Person person) {
            for (int i = 0; i < 10; i++) {
                if(person.c.get(i) > c.get(i))
                    return 1;
                else if (person.c.get(i) < c.get(i))
                    return -1;
            }
            return name.compareTo(person.name);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }
    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Person[] ppl = new Person[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.next().replace(":", "");
            ppl[i] = new Person(name, scanner.next());
            scanner.next();
        }
        Arrays.sort(ppl);
        for(Person p : ppl)
            System.out.println(p.name);
        System.out.println("=".repeat(30));
    }
}
