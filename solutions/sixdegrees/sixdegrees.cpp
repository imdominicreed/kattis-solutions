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
vector<vector<int>> children(3000, vector<int>());
int dfs(vector<pair<int, unordered_set<int>>>* new_graph, bool vis[], int depth, int curr) {

}

void solve() {
  int m;
  cin >> m;
  unordered_map<string, int> map_2;
  int count = 0;
  for(int i =0; i <m; i++) {
    string a,b;
    cin >> a >> b;
    if(map_2.find(a) == map_2.end())  {
      map_2[a] = count;
      count++;
    }
    if(map_2.find(b) == map_2.end()) {
      map_2[b] = count;
      count ++;
    }
    children[map_2[a]].push_back(map_2[b]);
    children[map_2[b]].push_back(map_2[a]);
  }
  vector<pair<int, unordered_set<int>>> new_graph(count);
  bool vis[count];
  for(int i = 0; i < count; ++i){
    new_graph[i].first = i;
    queue<pair<int, int>> q;
    memset(vis, 0, sizeof(vis));
    q.push({i, 0});
    vis[i] = true;
    while(q.size()){
      pair<int, int> pop = q.front(); q.pop();
      new_graph[i].second.insert(pop.first);
      if(pop.second == 6) continue;
      for(int child : children[pop.first]){
        if(!vis[child]){
          vis[child] = 1;
          q.push({child, pop.second+1});
        }
      }
    }
  }
  sort(new_graph.begin(), new_graph.end(), [](pair<int, unordered_set<int>>& lhs, pair<int, unordered_set<int>>& rhs) {return rhs.second.size() > lhs.second.size();});
  int able_to_remove = count/20;
  unordered_set<int> ret = new_graph[0].second;
  for(int i = 1; i < new_graph.size(); ++i){
    auto it = new_graph[i].second;
    unordered_set<int> nxt;
    for(int v : it){
      if(ret.find(v) != ret.end()){
        nxt.insert(v);
      }
    }
    ret = nxt;
  }
  cout << ((ret.size() >= count - able_to_remove) ? "YES" : "NO") << endl;
}
int main() {
  int t;
  cin >> t;
  for(int i = 0; i < t; i++) {
    solve();
  }
}