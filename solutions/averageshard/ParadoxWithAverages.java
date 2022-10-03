import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class ParadoxWithAverages {
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
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            // taking in data
            int csStudents = scanner.nextInt();
            int econStudents = scanner.nextInt();
            double csTotalIQ = 0;
            int arr[] = new int[csStudents];
            for (int j = 0; j < csStudents; j++) {
                arr[j] = scanner.nextInt();
                csTotalIQ += arr[j];
            }
            double csAvgIQ = csTotalIQ / csStudents;
            double econTotalIQ = 0;
            for (int j = 0; j < econStudents; j++) {
                econTotalIQ += scanner.nextInt();
            }
            double econAvgIQ = econTotalIQ / econStudents;
            //calculation
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < csAvgIQ && arr[j] > econAvgIQ)
                    count++;
            }
            System.out.println(count);
        }
    }

}
