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
    int t;
    cin >> t;
    for(int i = 0; i<t; i++) {
        int a,b,d;
        cin >> a  >> b >> d;
        cout << (d % __gcd(a,b) ? "No" : "Yes") << endl;
    }
}