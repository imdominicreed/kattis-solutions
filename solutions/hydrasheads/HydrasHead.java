import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HydrasHead {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int t = scanner.nextInt();
        while (h != 0 || t != 0){
            if (h == 1 && t == 0) {
                System.out.println(-1);
                continue;
            }
            boolean[][] visited = new boolean[1000][1000];
            int[] arr = new int[3];
            arr[1] = h;
            arr[2] = t;
            Queue<int[]> q = new LinkedList<>();
            q.add(arr);
            while (!q.isEmpty()) {
                int[] p = q.poll();
                if (visited[p[1]][p[2]])
                    continue;
                visited[p[1]][p[2]] = true;
                if (p[2] == 0 && p[1] == 0) {
                    System.out.println(p[0]);
                    break;
                }
                int[] clone = p.clone();
                if (clone[1] >= 2) {
                    clone[0]++;
                    clone[1] -= 2;
                    q.add(clone);
                }
                clone = p.clone();
                if (clone[2] >= 1) {
                    clone[2]++;
                    clone[0]++;
                    q.add(clone);
                }
                clone = p.clone();
                if (clone[2] >= 2) {
                    clone[2] -= 2;
                    clone[1]++;
                    clone[0]++;
                    q.add(clone);
                }
            }
            h = scanner.nextInt();
            t = scanner.nextInt();

        }
    }
}
