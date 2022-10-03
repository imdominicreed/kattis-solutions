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
typedef long long ll;

int main() {
  int m;
  cin >> m;
  if(m==1) {
    cout << 1;
    return 0;
  }
  m -= 2;
  set<ll> s;
  ll curr = 1;
  int size = 1;
  while(s.size() <= 60000) {
  ll hold = curr;
  ll right = 0;
    while(hold) {
      if(hold & 1) right |= 1;
      right <<= 1;
      hold >>= 1;
    }
    right >>= 1;
    ll shifted = curr << size;
    s.insert(shifted | right);
    shifted <<= 1;
    ll bit = 1LL << size;
    s.insert(shifted | right);
    s.insert(shifted | right | bit);
    curr++;
    bit>>= 1;
    if(!(bit & curr)) {
      size++;
    }
  } 
   int i = 0;
    for(long l : s) {
      if( i== m) {
        cout << l;
        return 0;
      }
      i++;
    }
}