import java.io.*;
import java.util.*;


class notablequotes {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		var br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		String input = sb.toString();
		List<Character> order = new ArrayList<>(List.of('"', '\'', '!', '@', '#', '$', '%', '^', '&', '*'));
		List<String> start = new ArrayList<>(List.of("\"", "'", "Q=!", "Q=@", "Q=#", "Q=$", "Q=%", "Q=^", "Q=&", "Q=*"));
		for(int i = 0; i < 26; i++) {
			order.add((char) ('a' + i));
			start.add("Q=" + (char) ('a' + i));
		}	
		for(int i = 0; i < 26; i++) {
			order.add((char) ('A' + i));
			start.add("Q=" + (char) ('A' + i));
		}
		HashSet<Character> in = new HashSet<>(); for(char o : order) in.add(o);
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			boolean matches = false;
			for(String m : start) {
				if(m.length() + i >= input.length()) continue;
				for(int j = 0; j < m.length(); j++) {
					if(m.charAt(j) != input.charAt(i+j)) break;
					matches = j == m.length()-1;
				}
				if(matches) {
					char ending = m.charAt(m.length()-1);
					HashSet<Character> visited = new HashSet<>();
					int curr = i + m.length();
					while(input.charAt(curr) != ending) {
						char letter = input.charAt(curr);
						if(in.contains(letter)) visited.add(letter);
						char test = input.charAt(curr+1);
						if(letter == '\\' && ending == (input.charAt(curr+1))) {
							visited.add(ending);
							curr++;
						}
						curr++;
					}
					int newMatching = -1;
					for(int j = 0; j < order.size(); j++) {
						newMatching = j;
						if(!visited.contains(order.get(j))) break;
					}
					output.append(start.get(newMatching));
					for(int j = i + m.length(); j < curr; j++) {
						char letter = input.charAt(j);
						if(letter == '\\' && ending == (input.charAt(j+1))) {
							output.append(input.charAt(j+1)); j++;
						} else output.append(input.charAt(j));
					}
					output.append(order.get(newMatching));
					i = curr;
					break;
				}
			}
			if(!matches) output.append(input.charAt(i));
		}
		System.out.println(output);
	}
}

