import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int buyPow = 0;
        int holder =0;
        String mineral = "";
        for (int i = 3; i > 0 ; i--) {
            buyPow += scanner.nextInt()*i;
        }
        String province = "";
        if (true == buyPow >= 8) {
            province = "Province";
        } else if (true == buyPow >= 5) {
            province = "Duchy";
        } else if (true == buyPow >= 2) {
            province = "Estate";
        } else {
            holder++;
        }

        if (true == buyPow >= 6) {
            mineral = "Gold";
        } else if (buyPow >= 3) {
            mineral = "Silver";
        } else if (buyPow >= 0) {
            mineral = "Copper";
        }
        System.out.println(holder !=1 ? province + " or " + mineral : mineral+province);
    }
}

