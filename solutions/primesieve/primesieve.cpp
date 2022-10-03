#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")

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
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, q;
  cin >> n >> q;
  vector<bool> not_primes(n+1);
  for(int i = 2; i * i <= n; i++) {
    if(not_primes[i]) continue;
    for(int j = i+i; j <= n; j += i) {
      not_primes[j] = true;
    }
  }
  not_primes[1] = true;
  int c = 0;
  for(int i = 1; i < n+1; i++) {
    if(!not_primes[i]) c++;
  }
  cout << c << '\n';
  for(int i = 0; i < q; i++) {
    int a;
    cin >> a;
    cout << (not_primes[a] ? 0 : 1) << '\n';
  }
}