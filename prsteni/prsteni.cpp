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
    int n;
    cin >> n;
    int top = 1;
    int bottom = 1;
    int prev;
    cin >> prev;
    for(int i = 0; i < n-1; i++) {
        int num;
        cin >> num;
        bottom *= num;
        top *= prev;
        int g = gcd(top, bottom);
        top /= g;
        bottom /= g;
        prev = num;
        cout << top << "/" << bottom << endl;
    }
}
