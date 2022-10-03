import java.util.Scanner;

public class FiftyShadesOfPink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        int color = 0;
        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            if (line.toLowerCase().contains("pink") || line.toLowerCase().contains("rose")) {
                color++;
            }
        }
        if (color != 0) {
            System.out.println(color);
        } else {
            System.out.println("I must watch Star Wars with my daughter");
        }
    }
}
