import java.nio.file.StandardWatchEventKinds;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ElevatorTrouble {
    static class Pair {
        int coords;
        long numTraveled;
        Pair(int coords, long numTraveled) {
            this.coords = coords;
            this.numTraveled = numTraveled;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int goal = scanner.nextInt();
        int up = scanner.nextInt();
        int down = scanner.nextInt();
        if (start == goal) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[n+1];
        Queue<Pair> current = new LinkedList<>();
        current.add(new Pair(start,0));
        while (!current.isEmpty()) {
            Pair coords = current.poll();

            if (coords.coords- down >= 1 && !visited[coords.coords-down]) {
                visited[coords.coords-down] = true;
                if (coords.coords-down == goal) {
                    System.out.println(coords.numTraveled+1);
                    return;
                }
                current.add(new Pair(coords.coords - down, coords.numTraveled + 1));
            }
            if (coords.coords + up <= n && !visited[coords.coords+up]) {
                visited[coords.coords+up] = true;
                if (coords.coords+up == goal) {
                    System.out.println(coords.numTraveled+1);
                    return;
                }
                current.add(new Pair(coords.coords + up, coords.numTraveled + 1));
            }
        }
        System.out.println("use the stairs");
    }
}
