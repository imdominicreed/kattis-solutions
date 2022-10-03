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

int points(char p, char p2) {
  if (p == p2)
    return 1;
  if(p == 'R' && p2 == 'S')
    return 2;
  if(p == 'P' && p2 == 'R')
    return 2;
  if(p == 'S' && p2 == 'P')
    return 2;
  return 0;
} 

int main() {
  int r;
  cin >> r;
  string sven;
  cin >> sven;
  int n;
  cin >> n;
  vector<string> hands(n);
  int real_score = 0;
  for(int i = 0; i < n; i++) {
    cin >> hands[i];
    for(int j = 0; j<r; j++)
      real_score += points(sven[j], hands[i][j]);
  }
  int max_score = 0;
  for(int i = 0; i < r; i++) {
    int best_score = 0;
    for(char letter : "RSP") {
      int curr = 0;
      for(int j = 0; j < n; j++) {
        curr += points(letter, hands[j][i]);
      }
      best_score = max(curr, best_score);
    }
    max_score += best_score;
  }
  cout << real_score << endl;
  cout << max_score << endl;
}