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
  int n;
  cin >> n;
  while (n) {
    vector<int> arr(n);
    for(int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    vector<int> dp(n, INT32_MAX);
    vector<int> parent(n, -1);
    for(int i = n-1; i >= 0; i--) {
      int min_index = i+1;
      bool found = false;
      for(int j = i+1; j < n; j++) {
        if(arr[i] < arr[j] &&  (!found || (arr[min_index] >= arr[j] && dp[min_index] <= dp[j]))) {
          min_index = j;
          found = true;
        }
      }
      if(!found) {
        dp[i] = 1;
      } else {
        dp[i] = dp[min_index] + 1;
        parent[i] = min_index;
      }
    }

    int ind = 0;
    bool found = false;
    for(int i = 1; i < n; i++) {
      if(dp[i] >= dp[ind] && (!found || arr[i] < arr[ind])) {
        ind = i;
        found = true;
      }
    }
    vector<int> ans;
    while (ind != -1)    {
      ans.push_back(ind);
      ind = parent[ind];
    }
    cout << ans.size() <<  " ";
    for(int i = 0; i < ans.size() ; i++) {
      cout << arr[ans[i]] << " ";
    }
    cout << endl;
    cin >> n;
  }
}