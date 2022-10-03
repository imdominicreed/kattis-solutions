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


void replace(ll v, int i, vector<ll>& huts, vector<ll>& tree) {
  ll diff = v - huts[i];
  huts[i] = v;
  i++;
  while(i < tree.size()) {
    tree[i] += diff;
    i = i +(i & -i);
  }
}

ll get(int i, vector<ll>& tree) {
  i++;
  ll sum = 0;
  while(i) {
    sum += tree[i];
    i = i - (i& -i);
  }
  return sum;
}
ll range(int l, int r, vector<ll>& tree){
  return get(r, tree) - get(l-1, tree);
}
int main() {
  int n,q;
  ll sum = 0;
  cin >> n >> q;
  vector<ll> huts(n);
  vector<ll> tree(n+1);
  for(int i =0; i<n; i++) {
    ll v;
    cin >> v;
    sum += v;
    replace(v, i, huts, tree);
  }
  for(int i = 0; i<q; i++) {
    int h; ll v;
    cin >> h >> v;
    if(n == 1){
      cout << 0 << endl;
      continue;
    }
    sum += v - huts[h];
    replace(v, h, huts, tree);
    int l = 0;
    int r = n-1;
    while(l<=r) {
      int mb = (l+r+1) >> 1;
      ll l1 = range(0, mb-2,tree); ll r1 = range(mb,n-1,tree); ll s1 = range(mb-1, mb-1,tree)&1;
      ll l2 = range(0, mb-1,tree); ll r2 = range(mb+1,n-1,tree); ll s2 = range(mb, mb,tree)&1;
      ll l3 = range(0, mb,tree); ll r3 = range(mb+2,n-1,tree); ll s3 = range(mb+1, mb+1,tree)&1;
      if(l2 <= r2 && l3 <= r3) l = mb+1;
      else if (l2 >= r2 && l1 >= r1) r = mb-1;
      else {
        ll m1 = abs(abs(l1-r1)-s1);
        ll m2 = abs(abs(l2-r2)-s2);
        ll m3 = abs(abs(l3-r3)-s3);
        ll m = min(m1, min(m2,m3));
        if(m == m1) cout << mb-1 << endl;
        else if(m==m2) cout << mb << endl;
        else cout << mb+1 << endl;
        break;
      }
    }
  }
  return 0;
}