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
  while(n) {
    map<string, set<string>> map;
    string del;
    getline(cin, del);
    for(int i = 0; i <n; i++) {
      string seg;
      getline(cin, seg);
      stringstream str(seg);
      string name;
      getline(str, name, ' ');
      while(getline(str, seg,' ')) {
        map[seg].insert(name);
      }
    }
    for(auto key : map) {
      cout << key.first << " ";
      for(auto name : key.second) {
        cout << name << " ";
      }
      cout << endl; 
    }
    cout << endl;
    cin >> n;
  }
}