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

struct line {
  ll a;
  ll b;
  ll calc(ll x) {
    return a*x + b;
  }
};
bool overlap(line l1, line l2, line l3) {
  return (l1.a -l2.a) * (l3.b-l1.b) <= (l1.a-l3.a)*(l2.b-l1.b);
}
int main() {
  ll n, c;
  cin >> n >> c;
  vector<line> dq(n);
  ll fpt = 0;
  ll bkpt = 0;
  ll best_prev = 0;
  for(int i = 0; i <n; i++) {
    ll x;
    cin >> x;
    line l = {-2ll * x, x*x + best_prev};
    while(bkpt - fpt >= 2 && overlap(dq[bkpt-2], dq[bkpt-1], l)) {
      bkpt--;
    }
    dq[bkpt++] = l;
    while(fpt+1 < bkpt && dq[fpt].calc(x) >= dq[fpt+1].calc(x)) fpt++;
    best_prev = dq[fpt].calc(x) + x*x+c;
  }
  cout << best_prev;
}