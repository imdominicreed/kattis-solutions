// ***Cantina of Babel Solution***
// Difficulty: 3.1
// Time Limit: 1 second, Memory Limit: 1024 MB
// Acceptance: 44%
// CPU Time: 0.13 s
// Author: David Sturgill
// Source: 2015 ICPC North American Qualifier Contest
// Link: https://open.kattis.com/problems/cantinaofbabel


import java.util.*;

public class CatinaOfBabel {
    static class Node {
        String name;
        ArrayList<Node> inwards;
        ArrayList<Node> outwards;

        Node(String name) {
            this.name = name;
            inwards = new ArrayList<>();
            outwards = new ArrayList<>();
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
            String languageSpeak = line[1];
            peopleToLanguageSpeak.put(name, languageSpeak);
            languageSpeakToPeople.putIfAbsent(languageSpeak, new HashSet<>());
            languageSpeakToPeople.get(languageSpeak).add(name);
            for (int j = 1; j < line.length; j++) {
                String languageUnderstand = line[j];
                peopleToLanguageUnderstand.putIfAbsent(name, new HashSet<>());
                peopleToLanguageUnderstand.get(name).add(languageUnderstand);

                languageUnderstandToPeople.putIfAbsent(languageUnderstand, new HashSet<>());
                languageUnderstandToPeople.get(languageUnderstand).add(name);
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
                topOrder(visited, node, stack);
        }
        visited.clear();
        int max = 0;
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (!visited.contains(pop))
                max = Math.max(max, getSCCSize(visited, pop));
        }
        System.out.println(n - max);

    }

    public static int getSCCSize(HashSet<Node> visited, Node curr) {
        visited.add(curr);
        int sum = 1;
        for (Node child : curr.inwards) {
            if (!visited.contains(child))
                sum += getSCCSize(visited, child);
        }
        return sum;
    }

    public static void topOrder(HashSet<Node> visited, Node curr, Stack<Node> stack) {
        if (visited.contains(curr)) return;
        visited.add(curr);
        for (Node child : curr.outwards) {
            topOrder(visited, child, stack);
        }
        stack.add(curr);
    }
}

