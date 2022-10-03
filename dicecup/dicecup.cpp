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
  int a,b;
  cin >> a >> b;
  vector<int> list;
  list.resize(a*b);
  int max_num = 0;
  for(int i = 1; i <= a; i++) {
    for(int j = 1; j <= b; j++) {
      list[i+j] += 1;
      max_num = max(max_num, list[i+j]);
    }
  }
  for(int i = 0; i<list.size(); i++) {
    if(list[i] == max_num) {
      cout << i << endl;
    }
  }
  return 0;
}