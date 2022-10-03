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

int getnum(char l) {
    if(l == ' ') return 0;
    return (l- 'a') + 1;
}

void encrypt(string code) {
    int sum = 0;
    vector<int> ret;
    for(char letter : code) {
        sum += getnum(letter);
        sum %= 27;
        ret.push_back(sum);
    }
    for(int n : ret) {
        if(n == 0) cout << " "; 
        else cout << (char) ((n-1) + 'a');
    }
    cout << endl;
}

void decrypt(string code) {
    vector<int> ret;
    int curr = getnum(code[0]);
    ret.push_back(curr);
    for(int i = 1; i < code.length(); i++) {
        int num = getnum(code[i]);
        if(num < curr) num += 27;
        ret.push_back(num-curr);
        curr = num % 27;
    }
    for(int n : ret) {
        if(n == 0) cout << " "; 
        else cout << (char) ((n-1) + 'a');
        // cout << n << endl;
    }
    cout << endl;
    
}

void solve() {
    char type;
    cin >> type;
    string line;
    getline(cin, line);
    string code = line.substr(1);
    if(type == 'e') encrypt(code);
    else decrypt(code);
}

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) solve();
}