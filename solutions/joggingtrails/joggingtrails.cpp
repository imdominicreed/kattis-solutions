#include <bits/stdc++.h>

using namespace std;


int main() {
    while(true) {
    int n, m;
    cin >> n;
    if(!n) return 0;
    cin >> m;
    vector<vector<int>> d(n, vector<int>(n, 1000000000));
    vector<int> deg(n, 0);
    int sum = 0;
    for(int i = 0; i < m; i++) {
            int src, dst, w;
            cin >> src >> dst >> w;
            src--; dst--;
            deg[src]++;
            deg[dst]++;
            d[src][dst] = min(d[src][dst], w);
            d[dst][src] = min(d[src][dst], w);
            sum += w;
    }
    for(int i =0; i < n; i++) d[i][i] = 0;
    for(int k = 0; k < n; k++) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++) {
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
                d[j][i] = d[i][j];
           }
        }
    }
    vector<int> odd;
    for(int i =0 ;i < n; i++) {
        if(deg[i] % 2) odd.push_back(i);
    }
    vector<pair<int,int>> pairs;
    for(int i = 0; i < odd.size(); i++) {
        for(int j = i+1; j < odd.size(); j++) {
            pairs.push_back({odd[i], odd[j]});
        }
    }
    int left = odd.size();
		vector<int> dp(1 << n, 1'000'000'000);
    function<int (int, int)> dfs = [&](int mask, int curr) {
        if(left <= 1) return 0;
				if(dp[mask] != 1'000'000'000) return dp[mask];
        int best = 1'000'000'000;
        for(int i = curr; i < pairs.size(); i++) {
            auto p = pairs[i];
            int pair_mask = (1<< p.first) | (1 << p.second);
            if(pair_mask & mask) continue;
            left -= 2;
            mask |= pair_mask;
            best = min(best, d[p.first][p.second] + dfs(mask, i+1));
            mask ^= pair_mask;
            left +=  2;
        }
				dp[mask] = best;
        return best;
    };
    cout << sum + dfs(0, 0)<< endl;
    }
} 
