#include <bits/stdc++.h>

using namespace std;

int main() {
    string alpha; cin >> alpha;
    string target; cin >> target;
    vector<int> next(26, -1);
    vector<vector<int>> g(target.size(), vector<int>());
    for(int i = target.size()-1; i >= 0; i--) {
        g[i].resize(26);
        for(int j = 0; j < 26; j++) {
            g[i][j] = next[j];
        }
        next[target[i]- 'a'] = i;
    }
    queue<pair<int, int>> q;
    int smallest = INT32_MAX;
    for(int i = 0 ; i < alpha.size(); i++) {
        int point = next[alpha[i]- 'a'];
        if(point == -1) {
            smallest = 1; break;
        }
        q.push({point, 1});
    }
    vector<bool> visited(target.size());
    while(smallest == INT32_MAX) {
        auto pop = q.front(); q.pop();
        for(int i = 0; i < alpha.size(); i++) {
            int point =  g[pop.first][alpha[i] - 'a'];
            if(point == -1) {
                smallest = pop.second + 1;
                break;
            }
            if(visited[point]) continue;
            visited[point] = true;
            q.push({point, pop.second+1});
        }
    }
    int n; cin >> n;
    while(n--) {
        string curr; cin >> curr;
        int i = 1;
        int point = next[curr[0]-'a'];
        for(; i < curr.size(); i++) {
            if(point == -1) break;
            point = g[point][curr[i] - 'a'];
        }
        if(point == -1 && smallest == curr.size()) cout << 1 << endl;
        else cout << 0 << endl;
    }
    return 0;
}