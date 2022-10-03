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
  int a, b, k;
  cin >> a >> b >> k;
  int c = 0;
  for(int i = a; i <= b; i++) {
        bool find = true;
      for(int base = 2; base <= k; base++) {
      int alg = i;
      vector<int> pal;
      while(alg != 0) {
        int r = alg % base;
        alg /= base;
        pal.push_back(r);
      }
      for(int j = 0; j < pal.size()/2; j++) {
        if(pal[j] != pal[pal.size() - j-1]) {
          find = false;
          break;
        }
      }
      if(!find) break;
    }
    if(find) c++;
  }
  cout << c << endl;
}