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
struct box {
  double x1;
  double x2;
  double y1;
  double y2;
  string size;
}; 
bool in_range(double x1, double x2, double x) {
  return x1 <= x && x2 >= x;
}
int main() {
  int n;
  cin >> n;
  while(n) {
    vector<box> boxes;
    for(int i = 0; i < n; i++) {
      double x1, x2, y1, y2; string size;
      cin >> x1 >> y1 >> x2 >> y2 >> size;
      boxes.push_back({x1,x2,y1,y2,size});
    }
    int p;
    cin >> p;
    for(int i =0 ; i < p; i++) {
      double x, y; string size;
      cin >> x >> y >> size; 
      int ind = -1;
      for(int j = 0; j < boxes.size(); j++) {
        if(in_range(boxes[j].x1, boxes[j].x2, x) && in_range(boxes[j].y1, boxes[j].y2, y)) {
          ind = j; break;
        }
      }
      cout << size <<  " ";
      if (ind == -1) {
        cout << "floor";
      } else if (boxes[ind].size == size) {
        cout << "correct";
      } else {
        cout << boxes[ind].size;
      }
      cout << endl;
    }
    cout << endl;
    cin >> n;
  }
}