import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class DeliciousBubbleTea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTea = scanner.nextInt();
        ArrayList<Tea> teas = new ArrayList<>();
        for (int i = 0; i < numTea; i++) {
            teas.add(new Tea(scanner.nextInt()));
        }

        int cheapestTea = -1;
        int toppingAmounts = scanner.nextInt();
        int[] toppingPrice = new int[toppingAmounts];
        for (int i = 0; i < toppingAmounts; i++) {
            toppingPrice[i] = scanner.nextInt();
        }
        for (Tea tea: teas) {
            int comboAmounts = scanner.nextInt();
            for (int i = 0; i < comboAmounts; i++) {
                tea.addCombination(toppingPrice[scanner.nextInt()-1]);
            }
            if (cheapestTea == -1 ){
                cheapestTea = tea.getLowestPrice()+tea.getPrice();
            }
            cheapestTea = cheapestTea < tea.getLowestPrice()+tea.getPrice() ? cheapestTea : tea.getLowestPrice()+tea.getPrice();
        }
        int answer = scanner.nextInt()/cheapestTea;
        if (answer == 0) {
            answer =0;
        } else{
            answer = answer - 1;
        }
        System.out.println(answer);
    }
}
class Tea{
    int price;
    int lowestPrice = -1;
    public Tea(int price) {
        this.price = price;
    }
    public void addCombination(int n){ calculateLowestPrice(n);}
    public int getPrice() { return this.price; }
    public int getLowestPrice(){ return this.lowestPrice;}
    private void calculateLowestPrice(int priceCombo) {
        if (this.lowestPrice == -1) {
            this.lowestPrice = priceCombo;
        }
        if (priceCombo < this.lowestPrice )
        this.lowestPrice = priceCombo;
    }
}
