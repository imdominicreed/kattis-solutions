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
  unordered_map<string, int> map;
  vector<string> typing;
  string line;
  getline(cin, line);
  stringstream ss(line);
  string word;
  int counter = 0;
  while(ss >> word) {
    map.insert({word, counter});
    typing.push_back(word);
    counter++;
  }
  int n;
  cin >> n;
  vector<vector<string>> songs(n);
  for(int i =0; i < n; i++) {
    songs[i].resize(counter);
    for(int j = 0; j < counter; j++) {
      cin >> songs[i][j];
    }
  }
  int sort_num;
  cin >> sort_num;
  for(int i = 0; i < sort_num; i++) {
    string type;
    cin >> type;
    int list_num = map[type];
    stable_sort(songs.begin(), songs.end(), [list_num](vector<string> o1, vector<string> o2) {
      return o1[list_num].compare(o2[list_num]) < 0;
    });
    for(int j = 0; j < counter; j++) {
      cout << typing[j] << " ";
    }
    cout << endl;
    for(int j = 0; j < n; j++) {
      for(int k = 0; k < counter; k++) {
        cout << songs[j][k] << " ";
      }
      cout << endl;
    }
    cout << endl;
  }
}