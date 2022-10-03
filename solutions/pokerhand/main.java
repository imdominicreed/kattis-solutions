import java.lang.reflect.Array;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Cards cards = new Cards();
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> cardMap = new HashMap<Character, Integer>();
        String allCards = scanner.nextLine();
        int Index = 0;
        for (var i = 0; i < 5; i++) {
            cards.setCardRank(allCards.charAt(Index));
            int previousIndex = Index;
            Index = allCards.indexOf(" ", previousIndex + 1) + 1;
        }
        for(var i =0; i< 5; i++) {
            if(cardMap.containsKey(cards.getCardRank(i))) {
                cardMap.compute(cards.getCardRank(i), (k,v) ->v+1);

            } else {
                cardMap.put(cards.getCardRank(i),1);
            }
        }
        int sum =-1;
        for(int value: cardMap.values()) {

            sum = value > sum ? value : sum;

        }
        System.out.println(sum);

    }
}
class Cards {
private ArrayList<Character> cardRank = new ArrayList<Character>();
public void setCardRank(char cardRank) {
        this.cardRank.add(cardRank);
    }
    public Character getCardRank(int i) {
    return this.cardRank.get(i);
    }
}