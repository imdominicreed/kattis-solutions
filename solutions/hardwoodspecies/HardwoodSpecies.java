import java.io.*;
import java.util.*;

public class HardwoodSpecies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> treeOrder = new HashSet<>();
        HashMap<String, Float> trees = new HashMap<>();
        float total = 0;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            trees.putIfAbsent(line, 0F);
            treeOrder.add(line);
            trees.put(line, trees.get(line) + 1F);
            total++;
        }
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        ArrayList<String> a = new ArrayList<>(treeOrder);
        a.sort(Comparator.naturalOrder());
        for (String tree : a) {
            bw.write(tree);
            bw.write(" ");
            bw.write(String.valueOf((trees.get(tree) / total) * 100F));
            bw.write("\n");
        }
        bw.flush();
    }
}
