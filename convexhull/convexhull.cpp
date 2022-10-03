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
ll overcross(pair<ll,ll> f, pair<ll,ll> s, pair<ll,ll> l) {
  return (l.second-f.second) *(s.first - f.first) - (s.second-f.second) * (l.first-f.first);
}
bool solve() {
  int n = 0;
  cin >> n;
  if(n==0) return false;
  vector<pair<ll,ll>> points;
  vector<pair<ll,ll>> h;
  for(int i = 0; i <n; i++) {
    ll a, b;
    cin >> a >> b;
    points.push_back(make_pair(a,b));
  }
  points.erase(unique(points.begin(), points.end()), points.end());
  sort(points.begin(), points.end());
  n = points.size();
  if(n >= 3) {
    for(int i = 0; i< n; i++) {
      while(h.size() > 1 && overcross(h[h.size()-2], h.back(), points[i]) <= 0) {
        h.pop_back();
      }
      h.push_back(points[i]);
    }
    int pt = h.size();
    for(int i = n-2; i >= 0; i--) {
      while(h.size() > pt && overcross(h[h.size()-2], h.back(), points[i]) <= 0) {
        h.pop_back();
      }
      h.push_back(points[i]);
    }
    h.pop_back();
  } else {
    h = points;
  }
  cout << h.size() << endl;
  for(int i = 0; i < h.size(); i++) {
    cout << h[i].first << " " << h[i].second << endl;
  }
  return true;
}
int main() {
  while(solve());
}