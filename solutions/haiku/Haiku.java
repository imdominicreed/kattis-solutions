import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Haiku {
    static class Node extends HashMap<Character, Node> {
        char data;
        boolean end;

        Node(char data, boolean end) {
            this.data = data;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return data;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node('!', false);
        }

        boolean search(String str, int index, int syllables, int goal) {
            Node current = root;
            if (syllables > goal)
                return false;
            for (int i = index; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (letter == ' ')
                    if (index != i)
                        return false;
                    else
                        continue;
                if (current.containsKey(letter)) {
                    current = current.get(letter);
                    if (current.end && i + 1 != str.length() && search(str, i + 1, syllables + 1, goal))
                        return true;
                } else
                    return false;
            }

            return syllables == goal;
        }

        void insert(String str) {
            Node current = root;
            boolean inMap = true;
            for (int i = 0; i < str.length(); i++) {
                if (inMap && current.containsKey(str.charAt(i))) {
                    current = current.get(str.charAt(i));
                    current.end |= i + 1 == str.length();
                } else {
                    inMap = false;
                    Node node = new Node(str.charAt(i), i + 1 == str.length());
                    current.put(node.data, node);
                    current = node;
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int s = scanner.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < s; i++) {
            trie.insert(scanner.nextLine());
        }
        boolean isHaiku = trie.search(scanner.nextLine(), 0, 1, 5);
        isHaiku &= trie.search(scanner.nextLine(), 0, 1, 7);
        isHaiku &= trie.search(scanner.nextLine(), 0, 1, 5);
        if (isHaiku)
            System.out.println("haiku");
        else
            System.out.println("come back next year");
    }
}
