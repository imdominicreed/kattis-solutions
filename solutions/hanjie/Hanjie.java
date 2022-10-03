import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hanjie {
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

    static ArrayList<Integer>[] rowReqs;
    static ArrayList<Integer>[] columnsReqs;
    static int columns;
    static int rows;
    static long ans;

    static class State {
        long grid;
        int row;
        int requirement;
        int index;

        State(long grid, int row, int requirement, int index) {
            this.grid = grid;
            this.row = row;
            this.requirement = requirement;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        FastReader scanner = new FastReader();
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        rowReqs = new ArrayList[rows];
        columnsReqs = new ArrayList[columns];
        for (int i = 0; i < rows; i++) {
            int reqs = scanner.nextInt();
            rowReqs[i] = new ArrayList<>(reqs);
            for (int j = 0; j < reqs; j++) {
                rowReqs[i].add(scanner.nextInt());
            }
        }
        for (int i = 0; i < columns; i++) {
            int reqs = scanner.nextInt();
            columnsReqs[i] = new ArrayList<>(reqs);
            for (int j = 0; j < reqs; j++) {
                columnsReqs[i].add(scanner.nextInt());
            }
        }
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, 0));
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.requirement == rowReqs[state.row].size()) {
                if (state.row+1 == rows) {
                    ans += checkColumns(state.grid) ? 1 : 0;
                } else {
                    queue.add(new State(state.grid, state.row + 1, 0, 0));
                }
                continue;
            }
            int numFill = rowReqs[state.row].get(state.requirement);
            long mask = ((1L << numFill) - 1) << (state.row * columns);
            for (int i = state.index; i < columns; i++) {
                if (i + numFill <= columns)
                    queue.add(new State(state.grid | mask << i, state.row, state.requirement + 1, i + numFill + 1));
                else
                    break;
            }
        }
        System.out.println(ans);
    }

    public static boolean checkColumns(long grid) {
        for (int i = 0; i < columns; i++) {
            ArrayList<Integer> requirements = columnsReqs[i];
            int reqIndex = -1;
            int requirement = 0;
            long mask = 1 << i;
            for (int j = 0; j < rows; j++) {
                if ((mask & grid) != 0) {
                    reqIndex++;
                    if (reqIndex == requirements.size())
                        return false;
                    requirement = requirements.get(reqIndex);

                    while (j < rows && (mask & grid) != 0) {
                        requirement--;
                        mask <<= columns;
                        j++;
                    }
                    if (requirement != 0 || j > rows)
                        return false;
                }
                mask <<= columns;
            }
            if (reqIndex + 1 != requirements.size())
                return false;
        }
        return true;
    }
/*
    public static void buildARow(long grid, int row, int requirement, int index) {
        if (row == rows) {
            ans += checkColumns(grid) ? 1 : 0;
            return;
        }
        if (requirement == rowReqs[row].size()) {
            buildARow(grid, row + 1, 0, 0);
            return;
        }
        int numFill = rowReqs[row].get(requirement);
        long mask = ((1L << numFill) - 1) << (row * columns);
        for (int i = index; i < columns; i++) {
            if (i + numFill <= columns)
                buildARow(grid | mask << i, row, requirement + 1, i + numFill + 1);
        }
    }
    */

}


