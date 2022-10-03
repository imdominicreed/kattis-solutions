#include <bits/stdc++.h>
using namespace std;

void dfs1(vector<vector<int>>& g, vector<int>& stack, vector<bool>& visited, int src) {
		visited[src] = true;
		for(int c : g[src]) {
				if(!visited[c]) dfs1(g, stack, visited, c);
		}
		stack.push_back(src);
}

void dfs2(vector<vector<int>>& g, vector<bool>& visited, int src, int comp, vector<int>& scc) {
		visited[src] = true;
		for(int c : g[src]) {
			if(!visited[c]) dfs2(g, visited, c, comp, scc);
		}
		scc[src] = comp;	
}			
		
int main() {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
		int n,k; cin >> n >> k;
		vector<vector<int>> g(k+k, vector<int>());
		vector<vector<int>> g_inv(k+k, vector<int>());
		for(int i = 0; i < n; i++) {
				string s; cin >> s;
				for(int j = 0; j < k; j++) {
						if(s[j] == 'X') continue; // F means + k
						int start = j + (s[j] == 'F' ? k : 0);
						for(int a = 0; a < k; a++) {
								if(j == a || s[a] == 'X') continue;
								int dst = a + (s[a] == 'T' ? k : 0);
								g[start].push_back(dst);
								g_inv[dst].push_back(start);
						}
				}
		}
		vector<bool> visited(k+k);
		vector<int> stack;
		for(int i = 0; i < k*2; i++) {
				if(!visited[i]) dfs1(g, stack, visited, i);
		}
		vector<int> scc(k+k);
		for(int i = 0; i < k*2; i++) visited[i] = false;
		int comp = 0;
		while(stack.size()) {
			int pop = stack.back(); stack.pop_back();
			if(visited[pop]) continue;
			dfs2(g_inv,visited, pop, comp, scc);
			comp++;
		}
		for(int i = 0; i < k; i++) {
				if(scc[i] == scc[i+k]) {
						cout << -1 << endl;
						return 0;
				}
		}
		string ans(k, 'X');
		function<bool (int)> dfs = [&](int curr) {
			if((curr>= k && (visited[curr-k] || ans[curr-k] == 'T')) || (curr < k && (ans[curr] == 'F' || visited[curr+k]))) return false;
			if(visited[curr]) return true;
			visited[curr] = true;
			for(int c : g[curr])
				if(!dfs(c))	return false;
			return true;
		};
		for(int i = 0; i < k; i++) {
		    if(ans[i] != 'X') continue;
			for(int j = 0; j < k + k; j++) visited[j] = false;
			if(dfs(i+k)) {
			    for(int j = 0;  j < k+k; j++)
			        if(visited[j]) ans[j % k] = j >= k ? 'F' : 'T';
			} else {
			    ans[i] = 'T';
			}
		}
		cout << ans << endl;	
}
