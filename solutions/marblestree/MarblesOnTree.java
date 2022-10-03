import java.util.*;

public class MarblesOnTree {
    static int moves;
    public static void tellParent(Box box) {
        box.parent.requirement += box.requirement;
        moves += Math.abs(box.requirement);
        box.parent.childrenAmount--;
        if (box.parent.childrenAmount == 0) {
            if (box.parent.parent == null) {
                return;
            }
            tellParent(box.parent);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int boxNum = scanner.nextInt();
            moves =0;
            if (boxNum == 0) {
                return;
            }
            Box[] boxes = new Box[boxNum];
            HashSet<Box> leafNodes = new HashSet<>();
            for (int i = 0; i < boxNum; i++) {
                if (boxes[i] == null) {
                    boxes[i] = new Box();
                }
                boxes[i].code = scanner.nextInt();
                boxes[i].addMarbles(scanner.nextInt());
                int numberChildren = scanner.nextInt();
                boxes[i].childrenAmount = numberChildren;
                if (numberChildren == 0) {
                    leafNodes.add(boxes[i]);
                }
                for (int j = 0; j < numberChildren; j++) {
                    int num = scanner.nextInt()-1;
                    if (boxes[num] == null) {
                        boxes[num] = new Box();
                    }
                    boxes[num].parent = boxes[i];

                }
            }
            for (Box node: leafNodes) {
                tellParent(node);
            }
            System.out.println(moves);
        }
    }
}

class Box {
    public int code;
    Box parent;
    int requirement;
    public int childrenAmount;
    public void addMarbles(int n) {
        requirement = 1-n;
    }
    @Override
    public int hashCode() {
        return code;
    }
}
