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
#define ll long long
using namespace std;


int main() {
    int n;
    cin >> n;
    vector<int> a(n);
    ll left = 0;
    ll right = 0;
    ll norm_right = 0;
    ll norm_left = 0;
    bool on_left = 1;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
        if(on_left) left += (i+2) * a[i];
        else right += i * a[i];
        if(on_left) norm_left += (i+1) * a[i];
        else norm_right += (i+1) * a[i];
        on_left &= a[i] != 0;
    }
    ll best = norm_left + norm_right;
    int i = 0;
    while(a[i] != 0) {
        best = max(best, left + norm_right);
        left -= a[i] * (i+2);
        left += a[i] * (i+1);
        i++;
    }
    i = n-1;
    while(a[i] != 0) {
        best = max(best, right + norm_left);
        right -= a[i] * (i);
        right +=a[i] * (i+1);
        i--;
    }
    cout << best << endl;
}