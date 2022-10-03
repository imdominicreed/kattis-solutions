import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SmallestMultiple {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        String line;
        while ((line = br.readLine()) != null) {
            String[] nums = line.split(" ");
            HashMap<Long, Long> vals = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                long num = Long.parseLong(nums[i]);
                for (long j = 2; j < num + 1; j++) {
                    long repitions = 0;
                    while (num % j == 0) {
                        num = num / j;
                        repitions++;
                    }
                    if (repitions != 0) {
                        if (vals.containsKey(j)) {
                            if (vals.get(j) < repitions) {
                                vals.put(j, repitions);
                            }
                        } else {
                            vals.put((j), repitions);
                        }
                    }
                }
            }
            BigInteger answer = new BigInteger("1");
            for (long key : vals.keySet()) {
                answer = answer.multiply(new BigInteger(String.valueOf((int) Math.pow(key, vals.get(key)))));
            }
            bw.append(answer + "\n");
        }
        bw.flush();
    }
}
