import java.util.Scanner;

public class FlowLayout {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        while (width != 0) {
            int boxWidth = scanner.nextInt();
            int boxLength = scanner.nextInt();
            int currWidth = 0;
            int currLength = 0;
            int totalLength = 0;
            int totalWidth = 0;
            while(boxWidth != -1 && boxLength != -1) {
                if (currWidth + boxWidth > width) {
                    totalWidth = Math.max(currWidth, totalWidth);
                    currWidth = 0;
                    totalLength += currLength;
                    currLength = 0;
                }
                currWidth += boxWidth;
                currLength = Math.max(currLength, boxLength);
                boxWidth = scanner.nextInt();
                boxLength = scanner.nextInt();
            }
            totalLength += currLength;
            totalWidth = Math.max(currWidth, totalWidth);
            System.out.println(totalWidth +" x " + totalLength);
            width = scanner.nextInt();
        }
    }
}
