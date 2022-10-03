import java.io.*;
import java.util.*;

public class Teque {
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

    private static final int MAX = 1000000;

    static class ArrQueue {
        int start, end;
        long[] queue;

        ArrQueue() {
            queue = new long[MAX * 2];
            start = MAX;
            end = start;
        }

        public void addLast(long val) {
            queue[end] = val;
            end++;
        }

        public void addFirst(long val) {
            start--;
            queue[start] = val;
        }

        public long removeFirst() {
            start++;
            return queue[start - 1];
        }

        public long removeLast() {
            end--;
            return queue[end];
        }

        public int size() {
            return end - start;
        }

        public boolean inRange(int val) {
            return val < size();
        }

        public long get(int i) {
            return queue[i + start];
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        ArrQueue frontQueue = new ArrQueue();
        ArrQueue backQueue = new ArrQueue();
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            int val = scanner.nextInt();
            switch (op) {
                case "push_back":
                    backQueue.addLast(val);
                    if (backQueue.size() > frontQueue.size())
                        frontQueue.addLast(backQueue.removeFirst());
                    break;
                case "push_front":
                    frontQueue.addFirst(val);
                    if (frontQueue.size() - 1  > backQueue.size())
                        backQueue.addFirst(frontQueue.removeLast());
                    break;
                case "push_middle":
                    if (backQueue.size() < frontQueue.size())
                        backQueue.addFirst(val);
                    else
                        frontQueue.addLast(val);
                    break;
                default:
                    bw.write((frontQueue.inRange(val) ? frontQueue.get(val) : backQueue.get(val - frontQueue.size())) + "\n");
                    break;
            }
            bw.flush();
        }
    }
}

