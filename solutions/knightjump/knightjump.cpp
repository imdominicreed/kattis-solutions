#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
#include <iterator>
#include <set>
#include <map>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <queue>
#include <stack>
#include <deque>
#include <tgmath.h>
#include <cassert>
#include <time.h>
#include <random>
#include <array>
using namespace std;


int main() {
    int n;
    cin >> n;
    vector<vector<bool> > legal(n, vector<bool>(n, true));
    pair<int,int> start;
    for(int i = 0; i <n; i++) {
        string line;
        cin >> line;
        for(int j = 0; j <n; j++) {
            if(line[j] == 'K') start = {i,j};
            else if(line[j] == '#') legal[i][j] = false;
        }
    }
    queue<pair<int,int> > q;
    q.push(start);
    vector<vector<int> > dist(n, vector<int>(n, -1));
    dist[start.first][start.second] = 0;
    while(q.size()) {
        auto pop = q.front(); q.pop();
        int r = pop.first;
        int c = pop.second;
        vector<pair<int,int> > legal_moves = {{r + 2, c + 1}, {r + 2, c - 1}, {r - 2, c - 1}, {r - 2, c + 1}, {r + 1, c + 2}, {r + 1, c - 2}, {r - 1, c + 2}, {r - 1, c - 2}};
        for(auto p : legal_moves) { 
            if(p.first >= n || p.first < 0 || p.second >= n || p.second < 0 
                || !legal[p.first][p.second] || dist[p.first][p.second] != -1) continue;
            dist[p.first][p.second] = dist[pop.first][pop.second] + 1;
            q.push(p);
        }
    }
    cout << dist[0][0] << endl;
}