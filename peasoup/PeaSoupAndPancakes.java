import java.util.Scanner;

public class PeaSoupAndPancakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            boolean peasoup = false;
            boolean pancakes = false;
            for (int j = 0; j < k; j++) {
                String food = scanner.nextLine();
                if (!peasoup && food.equals("pea soup")) {
                    peasoup = true;
                } else
                    pancakes |= food.equals("pancakes");
            }
            if (peasoup && pancakes) {
                System.out.println(name);
                return;
            }
        }

        System.out.println("Anywhere is fine I guess");

    }
}
