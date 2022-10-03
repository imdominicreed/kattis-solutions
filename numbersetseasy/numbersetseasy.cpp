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

vector<int> sets(1001); 
vector<bool> primes(1001, true);
int c;

int find(int x) {
  if(sets[x] == -1) return x;
  sets[x] = find(sets[x]);
  return sets[x];
}

void uni(int a, int b) {
  if(c > a || c > b || !primes[a]) return;
  a = find(a); 
  b = find(b);
  if(a == b) return;
  sets[a] = b;
}

void find_factors(int num) {
  for(int i = 1; i*i <=num; i++) {
    if(num % i == 0) {
      uni(i,num); 
      uni(num/i, num);
      }
  }
}

int solve() {
  for(int i= 0; i< 1001; i++) {
    sets[i] = -1;
  }
  int a, b;
  cin >> a >> b >> c;
  for(int i = a; i <= b; i++) {
    find_factors(i);
  }
  int ans = 0;
  vector<bool> visited(1001);
  for(int i = a; i <= b; i++) {
    if(!visited[find(i)]) {
       ans++;
    }
    visited[find(i)] = true;
  }
  return ans;
}

int main() {
  int c;

  for(int i = 2; i < 32; i++) {
    if(!primes[i]) continue;
    for(int j = i+i; j <= 1001; j+=i) {
      primes[j] = false;
    }
  }
  cin >> c;
  for(int i= 0 ; i < c ; i++) {
    cout << "Case #" << i+1 << ": " << solve() << endl;
  }
}