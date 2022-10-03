import java.io.*;
import java.util.*;

public class StringMismatching {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class Node {
        HashMap<Character, Node> go;
        Node fail;
        HashSet<Integer> output;
        Node() {
            go = new HashMap<>();
            output = new HashSet<>();
        }
        public void add(char letter) {
            if(!go.containsKey(letter)) 
                go.put(letter, new Node());
        }
        public boolean fail(char letter){
            return !go.containsKey(letter);
        }
        public Node next(char letter) {
            if(!go.containsKey(letter)) {
                if(root == this) return root;
                return fail.next(letter);
            }
            return go.get(letter);
        } 
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int n : output) {
                sb.append(n).append(' ');
            }
            return sb.toString();
        }
    }
    static Node root;
    public static void main(String[] args) {
        try {
            FastReader scanner = new FastReader();
            String line = scanner.nextLine();
            while(line != null) {
                solve(Integer.parseInt(line), scanner);
                line = scanner.nextLine();
            }
        } catch(Exception e) {}
    }
    public static void solve(int n, FastReader scanner) {
        root = new Node();
        root.fail = root;
        ArrayList<Integer> le = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Node curr = root;
            char[] arr = scanner.nextLine().toCharArray();
            le.add(arr.length);
            for(char l : arr) {
                curr.add(l);
                curr = curr.go.get(l);
            }
            curr.output.add(i);
        }
        Queue<Node> q = new LinkedList<>();
        for(var child : root.go.values()) {
            q.add(child);
            child.fail = root;
        }
        Node head = root;
        while(!q.isEmpty()) {
            Node pop = q.poll();
            for(var child : pop.go.entrySet()) {
                Node fail = pop.fail;
                while(fail != root && fail.fail(child.getKey()))
                    fail = fail.fail;
                child.getValue().fail = fail.next(child.getKey());
                child.getValue().output.addAll(fail.next(child.getKey()).output);
                q.add(child.getValue());
            }
        }
        char[] test = scanner.nextLine().toCharArray();
        StringBuilder[] sb = new StringBuilder[n];
        for(int i = 0; i < n; i++) sb[i] = new StringBuilder();
        Node curr = root;
        int i = 0;
        for(char l : test) {
            curr = curr.next(l);
            for(int o : curr.output) {
                sb[o].append(i-le.get(o)+1).append(" ");
            }
            i++;
        }
        for (int j = 0; j < sb.length; j++) {
            System.out.println(sb[j].toString());
        }
    }

}