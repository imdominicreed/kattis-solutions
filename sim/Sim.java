import jdk.jshell.spi.SPIResolutionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sim {
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
    static Node head;
    static Node tail;
    static class Node {
        char letter;
        Node prev;
        Node next;
        Node(char letter, Node prev, Node next) {
            this.letter = letter;
            this.prev = prev;
            this.next = next;
        }
        Node(char letter) {
            this.letter = letter;
        }
        Node remove() {
            if (this == head || tail == this)
                return this;
           prev.next = next;
           next.prev = prev;
           return prev;
        }
        void add(Node n) {
            n.prev = this;
            n.next = next;
            next.prev = n;
            next = n;
        }
    }
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String line = scanner.nextLine();
            head = new Node('!', null, null);
            tail = new Node('!', head, null);
            head.next = tail;
            Node curr = head;
            for (int j = 0; j < line.length(); j++) {
                char letter = line.charAt(j);
                if (letter == '[') {
                    curr = head;
                } else if (letter == ']')
                    curr = tail.prev;
                else if (letter == '<')
                   curr = curr.remove();
                else {
                    Node next = new Node(letter);
                    curr.add(next);
                    curr = next;
                }
            }
            curr = head.next;
            StringBuilder sb = new StringBuilder();
            while (curr != tail) {
                sb.append(curr.letter);
                curr = curr.next;
            }
            System.out.println(sb.toString());
        }

    }
}
