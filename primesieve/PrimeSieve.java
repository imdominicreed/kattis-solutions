    import java.util.BitSet;
    import java.util.HashSet;
    import java.util.Scanner;

    public class PrimeSieve {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            BitSet not_primes = new BitSet();
            not_primes.set(1);
            for (int i = 2; i < Math.sqrt(n) + 1; i++) {
                if (not_primes.get(i)) continue;
                for (int j = i+i; j < n +1; j += i) {
                    not_primes.set(j);
                }
            }
            System.out.println(n-not_primes.cardinality());
            for (int i = 0; i < q; i++) {
                System.out.println(not_primes.get(scanner.nextInt()) ? "0" : "1");
            }
        }
    }
