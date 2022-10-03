#include <bits/stdc++.h>
using namespace std;
int main() {
    int n; cin >> n;
    while(n) {
        string s; cin >> s;
        bool up = true;
        char piv = (char)'0'-1;
        vector<char> curr;
        bool done = false;
        for(int i = 0; i < s.size(); i++) {
            if(up) {
                if(s[i] < piv) 
                    up = false;
                piv = s[i];
                curr.push_back(s[i]);
            } else {
                if(!done && piv < s[i]) 
                    done = true;
                if(!done) piv = s[i];
                curr.push_back(piv);
            }
        }
        string out(curr.begin(), curr.end());
        cout << out << endl;
        n--;
    }
}
