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
  int d;
  cin >> d;
  if(d==0) {
    cout << "0 0";
    return 0;
  }
  long range = (long) sqrt(d);
  while(true) {
    for(long i = range; i >= 0; i--) {
      long sq = range * range;
      long f2 = i * i;
      int dist = sq - f2;
      if(dist == d) {
        cout << i << " " << range;
        return 0;
      } else if( dist > d) {
        break;
      }
    }
    if(d < (range*range) - ((range-1) * (range-1))) break;
    range++;
  }
  cout << "impossible" << endl;
}