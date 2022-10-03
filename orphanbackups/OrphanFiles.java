import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OrphanFiles {
    public static void main(String[] args ) throws IOException {
        TreeMap<String, Character> files = new TreeMap();
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = bi.readLine();
            if (!line.equals("")) {
                files.put(line, 'I');
            } else{
                break;
            }
        }
        TreeSet<String> orphans = new TreeSet<>();
        while (true) {
            String line = bi.readLine();
            if (line == null) {
                break;
            }
            String compare = line.substring(0, line.lastIndexOf('_', line.lastIndexOf('_') - 1));
            if (files.containsKey(compare)) {
                files.put(compare, '0');
            } else {
                orphans.add(line);
            }
        }
        Boolean noMismatches = true;
        for (String file : orphans) {
            noMismatches = false;
            System.out.println("F " + file);
        }
        for (String file : files.keySet()) {
            if (files.get(file) =='I') {
                noMismatches = false;
                System.out.println("I " + file);
            }
        }
        if (noMismatches) {
            System.out.println("No mismatches.");
        }
    }
}
