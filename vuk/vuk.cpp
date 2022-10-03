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
  int i;
  int j;
  int dist;
};
int main() {
  int n,m;
  vector<vector<int>> diff = {{1,0}, {-1,0}, {0,-1}, {0,1}};
  cin >> n >> m;
  vector<vector<int>> tree_dist(n, vector<int>(m, -1));
  tuple<int, int> cottage;
  tuple<int, int> wolf_t;
  auto cmp = [](state lhs, state rhs) {return lhs.dist > rhs.dist;};
    auto cmp_2 = [](state lhs, state rhs) {return lhs.dist < rhs.dist;};

  priority_queue<state, vector<state>, decltype(cmp)> trees(cmp);
  priority_queue<state, vector<state>, decltype(cmp_2)> wolf(cmp_2);
  for(int i = 0; i < n; i++) {
    string line;
    cin >> line; 
    for(int j = 0; j < m; j++) {
      if(line[j] == '+') {
        trees.push({i,j,0});
      } else if (line[j] == 'V'){
        wolf_t = {i, j};
      } else  if (line[j] == 'J') cottage = {i,j};
    }
  }
  while(trees.size()) {
    state pop = trees.top();
    trees.pop();
    if(tree_dist[pop.i][pop.j] != -1) continue;
   tree_dist[pop.i][pop.j] = pop.dist;
   for(vector<int> next: diff) {
    int next_i = pop.i + next[0];
    int next_j = pop.j + next[1];
    if(next_i >= 0 && next_i < n && next_j >= 0 && next_j <m && tree_dist[pop.i][pop.j] != -1) {
      trees.push({next_i, next_j, pop.dist+1});
    }
   }
  }
  wolf.push({get<0>(wolf_t), get<1>(wolf_t), tree_dist[get<0>(wolf_t)][get<1>(wolf_t)]});
  vector<vector<bool>> visited(n, vector<bool>(m, false));
  while(wolf.size()) {
    state pop = wolf.top();
    if(pop.i == get<0>(cottage) && pop.j == get<1>(cottage)) break;
    wolf.pop();
    if(visited[pop.i][pop.j]) continue;
    visited[pop.i][pop.j] = true;
    for(vector<int> next: diff) {
      int next_i = pop.i + next[0];
      int next_j = pop.j + next[1];
      if(next_i >= 0 && next_i < n && next_j >= 0 && next_j <m && !visited[next_i][next_j]) {
        wolf.push({next_i, next_j, min(pop.dist, tree_dist[next_i][next_j])});
      }
   } 
  }
  cout << wolf.top().dist << endl;
}