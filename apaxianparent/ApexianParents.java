import java.util.Scanner;

public class ApexianParents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String y = scanner.next();
        String p = scanner.next();
        char ch = y.charAt(y.length()-1);
        if (ch == 'e'){
            System.out.println(y+"x"+p);
        } else if(ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u') {
            System.out.println(y.substring(0, y.length()-1) + "ex" + p);
        } else if(ch == 'x' || y.charAt(y.length()-2) == 'e') {
            System.out.println(y+p);
        } else{
            System.out.println(y+"ex"+p);
        }
    }
}
