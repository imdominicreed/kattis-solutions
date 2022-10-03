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

#define GET(i, t) get<i>(t)

int main() {
  vector<string> moves;
  int start_i = 0;
  int start_j = 0;
  int lowest = 0;
  int highest = 0;
  int rightest = 0;
  int leftest = 0;
  string move;
  while(cin >> move) {
    moves.push_back(move);
    if(move == "down") {
      start_i++;
    } else if(move == "up") {
      start_i--;
    } else if(move == "left") {
      start_j--;
    } else if(move == "right") {
      start_j++;
    }
    lowest = min(lowest, start_i);
    highest = max(highest, start_i);
    rightest = max(rightest, start_j);
    leftest = min(leftest, start_j);
  }
  int row_size = abs(rightest-leftest)+1;
  int column_size = abs(highest-lowest) + 1;
  int path_i = abs(lowest);
  int path_j = abs(leftest);
  vector<vector<char>> grid(column_size, vector<char>(row_size, ' '));
  for(string move : moves) {
    if(move == "down") {
      path_i++;
    } else if(move == "up") {
      path_i--;
    } else if(move == "left") { 
      path_j--;
    } else if(move == "right") {
      path_j++;
    }
    grid[path_i][path_j] = '*';
  }
  grid[abs(lowest)][abs(leftest)] = 'S';
  grid[path_i][path_j] = 'E';
  for(int i = 0; i < row_size+2; i++) {
    cout << "#";
  }
  cout << endl;
  for(vector<char> row : grid) {
    cout << "#";
    for(char letter : row) {
      cout << letter;
    }
    cout << "#" << endl;
  }
  for(int i = 0; i < row_size+2; i++) {
    cout << "#";
  }
  cout << endl;
}