import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //The letters for the alphabet string
        String alphabet = scanner.nextLine();
        int alphaSize = alphabet.length();
        //The main string we query on
        String s = scanner.nextLine();
        //Normalizes alphabeta to an index of the length
        HashMap<Character, Integer> alphaIndex = new HashMap<>();
        for(int i = 0; i < alphabet.length(); i++) {
            alphaIndex.put(alphabet.charAt(i), i);
        }
        
        int graph[][] = new int[s.length()][alphabet.length()];
        int lookup[] = new int[alphabet.length()];
        Arrays.fill(lookup, -1); //setup the lookup all to -1

        for(int i = graph.length - 1; i >= 0; i--) {
            //sets graph[i] to look up
            for(int j = 0; j < alphabet.length(); j++) graph[i][j] = lookup[j];
            lookup[alphaIndex.get(s.charAt(i))] = i; //changes character to i'th index
        }
        //Set up queue for bfs
        Queue<int[]> queue = new LinkedList<>();
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < lookup.length; i++) {
            //if our lookup is -1 then we already know the shortest
            if(lookup[i] == -1) {
                shortest = 1;
                break;
            }
            //add it to the queue
            //queue is a size 2 array of {index, length of string}
            queue.add(new int[]{lookup[i], 0});
        }

        //indices we visited
        boolean[] visited = new boolean[s.length()];
        //if we found a shortest value
        while(shortest == Integer.MAX_VALUE) {
            int[] pop = queue.poll(); //pop is {index, length of string}
            int newDistance = pop[1] + 1; //update the distance by incrementing it by 1
            for(int i = 0; i < alphaSize; i++) {
                int newIndex = graph[pop[0]][i]; //gets next index
                if(newIndex == -1) {
                    shortest = newDistance+1; // since we found a missing index update shortest
                    break;
                }
                if(visited[newIndex]) continue; // if we already visited dont add it to queue
                visited[newIndex] = true; //mark index as visited
                queue.add(new int[]{newIndex, newDistance}); //add to queue
            }
        }

        int queries = scanner.nextInt(); //# of queries
        while(queries != 0) {
            String q = scanner.next(); //gets next query
            if(q.length() != shortest) { //if our query is not equal to length we skip
                queries--;
                System.out.println(0);
                continue;
            }
            //testing if query is a missing index
            int index = lookup[alphaIndex.get(q.charAt(0))];
            for(int i = 1; i < q.length(); i++) {
                index = graph[index][alphaIndex.get(q.charAt(i))]; // get next index for that letter
            }
            if(index == -1)System.out.println(1); // if it is -1 then it is missing
            else System.out.println(0);
            queries--;
        }
    }
}