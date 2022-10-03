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
#include <bitset>
#include <cassert>
#include <time.h>
#include <random>
#include <array>

using namespace std;

int main() {
  int n;
  cin >> n;
  while(n) {
    int num;
    cin>>num;
    int ans = 0;
    while(num) {
        bitset<32> b(num);
        ans = max(ans, (int)b.count());
        num /= 10;
    }
    cout << ans << endl;
    n--;
  }
}