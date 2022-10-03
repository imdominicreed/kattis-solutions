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
    int n,k;
    cin >> n>> k;
    vector<int> d(1 << k, -1);
    queue<int> q;
    for(int i = 0 ; i < n; i++) {
        string line;
        cin >> line;
        int ans = 0;
        for(auto l : line) {
            ans <<= 1;
            ans |= l-'F' ? 1 : 0;
        }
        q.push(ans);
        d[ans] = 0;
    }
    while(q.size()) {
        int p = q.front();
        q.pop();
        int mask = 1;
        for(int i = 0; i < k; i++) {
            int nw = p ^ mask;
            if(d[nw] == -1) {
                d[nw] = d[p] +1;
                q.push(nw);
            }
            mask <<= 1;
        }   
    }
    int m = 0;
    for(int num : d) {
        m = max(m, num);
    }
    cout << m << endl;
}