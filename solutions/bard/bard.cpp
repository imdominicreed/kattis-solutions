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
    int n,e;
    cin >> n >> e;
    vector<unordered_set<int>> g(n);
    int song_num = 0;
    for(int i = 0; i < e; i++) {
        int k;
        cin >> k;
        bool bard = false;
        vector<int> v;
        unordered_set<int> songs;
        for(int j = 0; j < k; j++) {
            int vill;
            cin >> vill;
            vill--;
            songs.insert(g[vill].begin(), g[vill].end());
            v.push_back(vill);
            bard |= vill == 0;
        }
        if(bard) {
            songs.clear();
            songs.insert(song_num++);
        }
        for(auto vill : v) g[vill].insert(songs.begin(), songs.end());
    }
    for(int i =0 ; i <n ; i++) {
        if(g[i].size() == song_num) cout << i+1 << endl;
    }
}