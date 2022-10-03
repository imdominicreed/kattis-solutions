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
  vector<vector<int>> adj(n, vector<int>(n));
  vector<int> size;
  for(int i = 0 ; i<n; i++) {
    cout << "? 1 " << i + 1 << endl;
    int edge; 
    cin >> edge;
    size.push_back(edge);
  }
  for(int i = 0; i < n; i++) {
    for(int j = i+1; j<n; j++) {
      cout << "? 2 " << i+1 << " " << j+1 << endl;
      int edge;
      cin >> edge;
      if(size[i] + size[j] - edge) {
        adj[i][j] = 1;
        adj[j][i] = 1;
      }
    }
  }
  cout << "!" << endl;
  for(int i = 0; i < n; i++) {
    for(int j = 0; j<n; j++) {
      cout << adj[i][j];
      if(j+1 != n) {
        cout << " ";
      }
    }
    if(i+1 != n)
      cout << endl;
  }
}