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
  int num_words = max(a, (b/2) + 1);
  for(int i = 0; i < num_words; i++) {
    int c = i;
    do {
      cout << (char) ('a' + c % 26);
      c /= 26;
    } while(c);
    cout << ' ';
  }
}