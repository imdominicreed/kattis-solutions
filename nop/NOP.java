import java.util.Scanner;

public class NOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int NOPCount = 0;
        int location = 0;
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            boolean startCache = Character.isUpperCase(letter);
            if (startCache && (location % 4) != 0) {
                NOPCount += 4-(location % 4);
                location += 4-(location % 4);

            }
                location++;
        }
        System.out.println(NOPCount);
    }
}
