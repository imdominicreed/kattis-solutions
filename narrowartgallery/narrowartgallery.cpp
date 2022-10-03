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
    cin >> n >> k;
    vector<vector<int>> dp0(n+1, vector<int>(n+1, (int) (1E9)));
    vector<vector<int>> dp1(n+1, vector<int>(n+1, (int) (1E9)));

    int total = 0;
    if (k != 0) {
        cin >> dp0[1][1] >> dp1[1][1];
        total = dp0[1][1] + dp1[1][1];
    } else {
        int a,b;
        cin >> a >> b;
        total += a + b;
    }
    dp0[1][0] = 0;
    dp1[1][0] = 0;
    for (int i = 2; i < n + 1; i++) {
        int row1;
        cin >> row1;
        total += row1;
        for (int j = 0; j < k + 1; j++) {
            int bestPrevious = min(dp0[i - 1][j], dp1[i - 2][j]);
            dp0[i][j] = min(dp0[i][j], bestPrevious);
            if (j != k) dp0[i][j + 1] = bestPrevious + row1;
        }
        int row2;
        cin >> row2;
        total += row2;
        for (int j = 0; j < k + 1; j++) {
            int bestPrevious = min(dp1[i - 1][j], dp0[i - 2][j]);
            dp1[i][j] = min(dp1[i][j], bestPrevious);
            if (j != k) dp1[i][j + 1] = bestPrevious + row2;
        }
    }
    cout << total - min(dp0[n][k], dp1[n][k]) << endl;
}
