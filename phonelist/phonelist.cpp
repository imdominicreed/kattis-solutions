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
struct node {
  char val;
  unordered_map<char, node*> children;
  bool end;
};
bool add(int c, string str, node* head) {
  auto child = head->children.find(str[c]);
  bool not_map = child == head->children.end();
  node* n;
  if(child == head->children.end()) {
    n = new node();
    n->val = str[c];
    n->end = false;
    head->children.insert({str[c], n});
  } else n = child->second;
  if(n->end) return false;
  if(c+1 == str.size()) {
    n->end = true;
    return not_map;
  }
  return add(c+1, str, n);
}
bool solve() {
  int n;
  cin >> n;
  node head;
  head.end = false;
  bool good = true;
  for(int i = 0; i < n; i++) {
    string str;
    cin >> str;
    good &= add(0, str, &head);
  }
  return good;
}

int main() {
  int t;
  cin >> t;
  for(int i = 0; i < t; i++) {
    if(solve()) cout << "YES" << endl; else cout << "NO" << endl;
  }
}