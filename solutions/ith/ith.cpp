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
//line segment is y-y1 = m(x-x1)
// y = x -x1 +y1
//y = -x x1 +y1
bool solve() {
    int x, y, q;
    cin >> x >> y >> q;
    if(!x) return false;
    vector<bool> row(y,false);
    vector<bool> column(x,false);
    vector<bool> negative(x+y,false);
    vector<bool> positive(x+y, false);
    for(int i = 0 ; i < q; i++) {
        int nx, ny;
        cin >> nx >> ny;
        nx--;ny--;
        row[ny] = true;
        column[nx] = true;
        positive[nx+ny] = true;
        negative[x-nx+ny] = true;
    }
    int ans = 0;
    for(int i = 0 ; i < x; i ++) {
        if(column[i]) continue;
        for(int j = 0;  j < y; j++) {
            if(row[j] || positive[i+j] || negative[x-i+j]) continue;
            ans++;
        }
    }
    cout << ans << endl;
    return true;
}

int main() {
    while(solve());
    return 0;
}