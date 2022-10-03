import java.util.*;

public class CatinaOfBabel {
    static class Node {
        String name;
        HashSet<Node> inwards;
        HashSet<Node> outwards;

        Node(String name) {
            this.name = name;
            inwards = new HashSet<>();
            outwards = new HashSet<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, HashSet<String>> languageSpeakToPeople = new HashMap<>();
        HashMap<String, String> peopleToLanguageSpeak = new HashMap<>();
        HashMap<String, HashSet<String>> peopleToLanguageUnderstand = new HashMap<>();
        HashMap<String, HashSet<String>> languageUnderstandToPeople = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0];
            names.add(name);
            peopleToLanguageSpeak.put(name, line[1]);
            languageSpeakToPeople.putIfAbsent(line[1], new HashSet<>());
            languageSpeakToPeople.get(line[1]).add(name);
            for (int j = 1; j < line.length; j++) {
                peopleToLanguageUnderstand.putIfAbsent(name, new HashSet<>());
                peopleToLanguageUnderstand.get(name).add(line[j]);
                languageUnderstandToPeople.putIfAbsent(line[j], new HashSet<>());
                languageUnderstandToPeople.get(line[j]).add(name);
            }
        }
        HashMap<String, Node> nodesMap = new HashMap<>();
        ArrayList<Node> nodes = new ArrayList<>();
        for (String name : names) {
            nodesMap.put(name, new Node(name));
            nodes.add(nodesMap.get(name));
        }
        for (String name : names) {
            for (String lang : peopleToLanguageUnderstand.get(name)) {
                if (!languageSpeakToPeople.containsKey(lang))
                    continue;
                for (String listNames : languageSpeakToPeople.get(lang))
                    nodesMap.get(name).inwards.add(nodesMap.get(listNames));
            }
            for (String listNames : languageUnderstandToPeople.get(peopleToLanguageSpeak.get(name)))
                nodesMap.get(name).outwards.add(nodesMap.get(listNames));
        }
        HashSet<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        for (Node node : nodes) {
            if (!visited.contains(node))
                recurse(visited, node, stack);
        }
        visited.clear();
        int max = 0;
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (!visited.contains(pop))
                max = Math.max(max, recurse2(visited, pop));
        }
        System.out.println(n - max);

    }

    public static int recurse2(HashSet<Node> visited, Node curr) {
        visited.add(curr);
        int sum = 1;
        for (Node child : curr.inwards) {
            if (!visited.contains(child))
                sum += recurse2(visited, child);
        }
        return sum;
    }

    public static void recurse(HashSet<Node> visited, Node curr, Stack<Node> stack) {
        visited.add(curr);
        for (Node child : curr.outwards) {
            if (!visited.contains(child))
                recurse(visited, child, stack);
        }
        stack.add(curr);
    }
}
