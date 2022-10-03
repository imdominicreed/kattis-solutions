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
    while(cin>>n) {
      vector<int> arr;
      for(int i = 0; i <n; i++) {
        int num;
        cin >> num;
        arr.push_back(num);
      }
      unordered_set<int> set;
      bool possible = true;
      for(int i = 1; i < n; i++) {
        int num = abs(arr[i] - arr[i-1]);
        set.insert(num);
        if(num < 1 || num > n-1) {
          possible = false;
          break;
       }
      }
      if(possible && set.size() == (n-1)) cout << "Jolly" << endl; else cout << "Not Jolly" << endl;;
    }
  }