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
using ll = long long;

int getState(char letter) {
  if (letter == '*' || letter == 'j') return 0;
  if(letter == '|' || letter == 't') return 1;
  return 2;
}
bool solve(string line) {
  stack<int> s;
  for(char l : line) {
    if ( l== '.') continue;
    if(isalpha(l)) {
      if(s.empty() || s.top() != getState(l)) return 0;
      s.pop();
    } else s.push(getState(l));
  }
  return s.empty();
}

int main() {
  int n;
  cin >> n;
  for(int i = 0; i< n; i++) {
    string line;
    cin >> line;
    if(solve(line)) cout << "YES";
    else cout << "NO";
    cout << endl;
  }
}
