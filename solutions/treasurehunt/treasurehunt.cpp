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
  int r, c;
  cin >> r >> c;
  string emp;
  getline(cin, emp);
  pair<int,int> loc = make_pair(0,0);
  vector<vector<pair<int,int>>> grid(r, vector<pair<int,int>>(c));
  for(int i = 0; i < r; i++) {
    string line;
    getline(cin, line);
    for(int j = 0; j< c; j++) {
      char letter = line[j];
      if(letter == 'E') grid[i][j] = make_pair(0,1);
      else if(letter == 'W') grid[i][j] = make_pair(0,-1);
      else if(letter == 'N') grid[i][j] = make_pair(-1,0);
      else if(letter == 'S') grid[i][j] = make_pair(1,0);
      else grid[i][j] = make_pair(0,0);
    }
  }
  vector<vector<bool>> visited(r, vector<bool>(c));
  int d = 0;
  while(true) {
    if(loc.first >= r || loc.first < 0 || loc.second >= c || loc.second < 0) {
      cout << "Out" << endl;
      return 0;
    }
    if(visited[loc.first][loc.second]) {
      cout << "Lost" << endl;
      return 0;
    }
    visited[loc.first][loc.second] = true;
    auto c = grid[loc.first][loc.second];
    if(c.first == 0 && c.second == 0) {
      cout << d << endl;
      return 0;
    }
    loc.first += c.first;
    loc.second += c.second;
    d++;
  } 
}