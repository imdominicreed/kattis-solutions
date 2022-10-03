import java.io.*;
import java.util.*;

public class RaidTeams {
    static class Player {
        String name;
        long skill1;
        long skill2;
        long skill3;

        Player(String name, long skill1, long skill2, long skill3) {
            this.name = name;
            this.skill1 = skill1;
            this.skill2 = skill2;
            this.skill3 = skill3;
        }


        @Override
        public String toString() {
            return name;
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

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        TreeSet<Player> skill1 = new TreeSet<>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.skill1-o2.skill1 != 0)
                    return Long.compare(o2.skill1, o1.skill1);
                return o1.name.compareTo(o2.name);
            }
        });
        TreeSet<Player> skill2 = new TreeSet<>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.skill2-o2.skill2 != 0)
                    return Long.compare(o2.skill2, o1.skill2);
                return o1.name.compareTo(o2.name);
            }
        });
        TreeSet<Player> skill3 = new TreeSet<>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.skill3-o2.skill3 != 0)
                    return Long.compare(o2.skill3, o1.skill3);
                return o1.name.compareTo(o2.name);
            }
        });
        TreeSet[] list = new TreeSet[]{skill1, skill2, skill3};

        for (int i = 0; i < n; i++) {
            Player player = new Player(scanner.next(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong());
            for (TreeSet set: list) {
                set.add(player);
            }
        }
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        while (skill1.size() >= 3) {
            ArrayList<Player> players = new ArrayList<>();
            for (TreeSet<Player> set: list) {
                Player player = set.first();
                for (int j = 0; j < 3; j++) {
                    list[j].remove(player);
                }
                players.add(player);
            }
            players.sort(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.name.compareTo(o2.name);
                }
            });
            for (Player player : players) {
                bw.write(player + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}