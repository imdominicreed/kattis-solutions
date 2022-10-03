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
  map<int, priority_queue<long>> map;
  for(int i = 0; i < n; i++) {
    string q;
    cin >> q;
    if(q == "add") {
      int e, l;
      cin >> e >> l;
      map[e].push(l);
    } else {
      long v;
      cin >> v;
      auto pop = map.lower_bound(v);
      long sum = 0;
      while (map.size()) {
        if(pop == map.end()) pop--;
        while(pop->first > v &&  pop != map.begin())  pop--;
        if(pop->first > v) break;
        v -= pop->first;
        sum += pop->second.top();
        pop->second.pop();
        if(!pop->second.size()) 
          map.erase(pop);
        pop = map.lower_bound(v);
      }
      cout << sum << endl;
    }
  }
}