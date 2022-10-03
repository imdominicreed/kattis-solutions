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
    cin >> n>>k;
    double sm = 0;
    double ma = 0;
    for(int i = 0; i < k; i++) {
        double num;
        cin >> num;
        sm += num;
        ma += num;
    } 
    sm += (n-k) * -3;
    ma += (n-k) * 3;
    cout << (sm/n) << " " << (ma/n) << endl;
}