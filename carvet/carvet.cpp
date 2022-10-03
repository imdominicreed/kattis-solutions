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
struct state {
  int first;
  int second;
  int distance;
};
int main () {
  int n, m;
  cin >> n >> m;
  pair<int,int> space;
  vector<pair<int,int>> checks = {make_pair(0,1), make_pair(0,-1), make_pair(1,0), make_pair(-1,0)};
  vector<vector<int>> grid(n, vector<int>(m));
  for(int i = 0; i < n; i++) {
    for(int j =0; j<m; j++) {
      int val;
      cin >> val;
      if (val == -1)
        space = make_pair(i,j);
      grid[i][j] = val;
    }
  }
  queue<state> q;
  int start_i, start_j;
  cin >> start_i >> start_j;
  start_i--;
  start_j--;
  q.push({start_i, start_j, 0});
  vector<vector<int>> dist(n, vector<int>(m, INT32_MAX));
  vector<vector<state>> parent(n, vector<state>(m));
  int i = 0;
  while(q.size()) {
    i++;
    auto pop = q.front();
    q.pop();
    if(dist[pop.first][pop.second] != INT32_MAX) continue;
    dist[pop.first][pop.second] = pop.distance; 
    for(auto check : checks) {
      int first = pop.first + check.first;
      int second = pop.second + check.second;
      if(first < 0 || second < 0 || first >= n || second >= m || grid[first][second] != grid[pop.first][pop.second]) continue;
      first += check.first;
      second += check.second;
      if(first < 0 || second < 0 || first >= n || second >= m || grid[first][second] == -2) continue;
      if(dist[first][second] == INT32_MAX || grid[first][second] < grid[parent[first][second].first][parent[first][second].second]) parent[first][second] = pop;
      if(dist[first][second] == INT32_MAX)
        q.push({first,second, pop.distance+1});
    }
  }
  if(dist[space.first][space.second] == INT32_MAX) {
    cout << "impossible" << endl;
  } else {
    while(space.first != start_i || space.second != start_j) {
      auto s = parent[space.first][space.second];
      cout << grid[s.first][s.second] << " ";
      space.first = s.first;
      space.second = s.second;
    }
    cout << endl;
  }
  

}