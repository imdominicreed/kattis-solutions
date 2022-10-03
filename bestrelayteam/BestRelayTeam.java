import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.*;

public class BestRelayTeam {

    static class FirstLeg implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return Double.compare(o1.firstleg, o2.firstleg);
        }
    }
    static class SecondLeg implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return Double.compare(o1.secondleg, o2.secondleg);
        }
    }
    static class Person implements Comparable<Person> {
        String name;
        double firstleg;
        double secondleg;
        Person(String name, double firstleg, double secondleg) {
            this.name = name;
            this.firstleg = firstleg;
            this.secondleg = secondleg;
        }

        @Override
        public boolean equals(Object obj) {
            Person person = (Person) obj;
            return name.equals(person.name);
        }

        @Override
        public int compareTo(Person o) {
            return Double.compare(secondleg, o.secondleg);
        }
    }
    static class Team extends ArrayList<Person> implements Cloneable{ ;
        double time;
        Team() {
            time =0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            people[i] = new Person(name, scanner.nextDouble(), scanner.nextDouble());
        }
        HashSet<Person> imbad = new HashSet<>();
        Arrays.sort(people, new FirstLeg());
        for (int i = 0; i < 4; i++) {
            imbad.add(people[i]);
        }
        Arrays.sort(people);
        for (int i = 0; i < 4; i++) {
            imbad.add(people[i]);
        }
        Team team = getBestTeam(new Team(), imbad, 0);
        System.out.println(team.time);
        System.out.println(team.get(0).name);
        team.remove(0);
        team.sort(new SecondLeg());
        for (Person name: team) {
            System.out.println(name.name);
        }
    }
    public static Team getBestTeam(Team team, HashSet<Person> people, int depth) {
        if (depth == 4)
            return team;
        Team bestTeam = null;
        double time = Double.MAX_VALUE;
        for (Person person: people) {
            Team newTeam = (Team) team.clone();
            newTeam.add(person);
            newTeam.time += depth == 0 ? person.firstleg : person.secondleg;
            HashSet<Person> clone = (HashSet<Person>) people.clone();
            clone.remove(person);
            Team currentTeam = getBestTeam(newTeam, clone, depth + 1);
            if (currentTeam.time < time) {
                time = currentTeam.time;
                bestTeam = currentTeam;
            }
        }
        return bestTeam;
    }
}