import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GCPC {
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

    static class TeamObject implements Comparable<TeamObject> {
        int team;
        int solved;
        int penalty;

        public TeamObject(int team, int solved, int penalty) {
            this.team = team;
            this.solved = solved;
            this.penalty = penalty;
        }

        public void add(int penalty) {
            this.penalty += penalty;
            solved++;
        }

        public int compareTo(TeamObject that) {
            if (solved - that.solved != 0)
                return solved - that.solved;
            if (penalty - that.penalty != 0)
                return that.penalty - penalty;
            return that.team - team;
        }


        @Override
        public boolean equals(Object x) {
            TeamObject that = (TeamObject) x;
            return this.compareTo(that) == 0;
        }
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TeamObject[] teams = new TeamObject[n];
        boolean[] in = new boolean[n];
        teams[0] = new TeamObject(0, 0, 0);
        TreeSet<TeamObject> better = new TreeSet<>();
        int indexOfTeam = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int team = scanner.nextInt() - 1;
            int penalty = scanner.nextInt();
            if (teams[team] == null)
                teams[team] = new TeamObject(team, 0, 0);
            if (in[team])
                better.remove(teams[team]);
            teams[team].add(penalty);
            if (teams[team].compareTo(teams[0]) > 0) {
                better.add(teams[team]);
                if(!in[team])
                    indexOfTeam++;
                in[team] = true;

            }
            if (team == 0) {
                while (better.size() > 0 && better.first().compareTo(teams[0]) < 0) {
                    in[better.pollFirst().team] = false;
                    indexOfTeam--;
                }
            }
            sb.append(indexOfTeam + 1);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
