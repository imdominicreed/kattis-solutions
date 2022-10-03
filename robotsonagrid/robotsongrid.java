import java.util.*;



public class robotsongrid {

	static long MOD = (1 << 31) - 1;
	static long dp[][];
	static int n;
	static char grid[][];
	public static void main(String[] a) {
			Scanner s = new Scanner(System.in);
			n = s.nextInt();
			grid = new char[n][];
			for(int i =0 ; i < n; i++) grid[i] = s.next().toCharArray();
			dp = new long[n][n];
			for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
			dp[n-1][n-1] = 1;
			long sum = dfs(0,0);
			if(!dfs1(0,0, new boolean[n][n])) System.out.println("INCONCEIVABLE");
			else if (sum == 0) System.out.println("THE GAME IS A LIE");
			else System.out.println(sum); 
	}
	static boolean dfs1(int i, int j, boolean[][] visited) {
		if(i < 0 || i == n || j < 0 || j == n) return false;
		if(grid[i][j] == '#') return false;
		if(i == n-1 && j == n-1) return true;
		if(visited[i][j]) return false;
		visited[i][j] = true;
		return dfs1(i+1,j, visited) | dfs1(i, j+1, visited) | dfs1(i-1, j, visited) | dfs1(i, j-1, visited);
	}
	static long dfs(int i, int j) {
		if(i < 0 || i == n || j < 0 || j == n) return 0;
		if(grid[i][j] == '#') return 0;
		if(dp[i][j] != -1) return dp[i][j];
		long sum = (dfs(i+1,j) + dfs(i, j+1)) % MOD;
		dp[i][j] = sum;
		return sum;
	}
}
