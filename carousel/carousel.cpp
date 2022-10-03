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
  int n, m;
  cin >> n >> m;
  while (n!= 0 || m != 0) {
    int bestT = 0;
    int bestP = 0;
    bool found = false;
    for(int i = 0; i<n; i++) {
      int t, p;
      cin >> t >> p;
      if(t==0) continue;
      if (t > m) continue;
      if(!found || 
      (((double) p)/t + 1E-6 < ((double) bestP)/bestT
      || (((double) p)/t - 1E-6 < ((double) bestP)/bestT
       && bestT < t))) {
        found = true;
        bestT = t;
        bestP = p;
      }
    }
    cin >> n >> m;
    if (found)
        cout << "Buy " << bestT  << " tickets for $" << bestP << endl;
      else 
        cout << "No suitable tickets offered" << endl;
  }
  return 0;
}