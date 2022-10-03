import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CpuExplosion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean[] primes = new boolean[1000001];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= 1000000; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    primes[j] = false;
                }
            }
        }
        int cases = scanner.nextInt();
        if (cases == 0) {
            return;
        }
        for (int i = 0; i < cases; i++) {
            long start = scanner.nextLong();
            long end = scanner.nextLong();
            int answer = 0;
            for (long a = 1; a < Math.pow(end, 0.3333); a++) {
                for (long b = -a + 2; ((a + b) * ((a * a) + (a * b) + b) * ((a * a * a) + (a * a * b) + (a * b) + b)) <= end; b++) {
                    long p1 = a + b;
                    long p2 = (a * p1) + b;
                    long p3 = (a * p2) + b;
                    long num = p1 * p2 * p3;
                    if (num > end) {
                        break;
                    } else {
                        if (primes[(int) p2] && primes[(int) p3] && primes[(int) p1]) {
                            long possibleAnswer = num;
                            long current = p3;
                                /*ArrayList<Long> nums = new ArrayList<>();
                                nums.add(p1);
                                nums.add(p2);
                                nums.add(p3);
                                 */
                            while (possibleAnswer <= end) {
                                if (possibleAnswer >= start) {
                                    answer++;
                                }
                                current = (current * a) + b;
                                // nums.add(current);
                                if (current > 1000000) {
                                    break;
                                }
                                if (!primes[(int) current]) {
                                    break;
                                }
                                possibleAnswer *= current;

                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
