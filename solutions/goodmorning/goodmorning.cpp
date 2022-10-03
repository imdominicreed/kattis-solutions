#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> g = {{1,2,3},{4,5,6},{7,8,9},{10,0,10}};

int best(int k, int a, int b) {
    if(abs(k-a) < abs(k-b)) return a;
    return b;
}

int dfs(int i,int j, int k, int curr) {
    if(i > 3 || (i == 3 && (j == 0 || j == 2) || j >= 3) || curr > 1000 || (i == 3 && j ==1 && curr == 0)) return curr;
    int b = 10000;
    b =  best(k, dfs(i,j, k, (curr * 10) + g[i][j]), b);
    b =  best(k, dfs(i+1, j, k, curr), b);
    b =  best(k, dfs(i+1, j, k, curr * 10 + g[i][j]), b);
    b =  best(k, dfs(i, j+1, k, curr), b);
    b =  best(k, dfs(i, j+1, k, curr * 10 + g[i][j]), b);
    return b;
}

int main() {
    int n; cin >> n;
    while(n--) {
        int k; cin >> k;
        cout << dfs(0,0,k,0) << endl;
    }
}