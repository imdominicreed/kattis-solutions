#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

struct station {
    ll location;
    ll price;
    int i;
};
int main() {
    cin.tie(0);
    ll n;
    cin >> n;
    ll g;
    cin >> g;
    ll ans = 0;
    vector<station> s;
    s.reserve(n);
    for(int i = 0; i < n; i++) {
        ll d, ga; cin >> d >> ga;
        s.push_back({d,ga,i});
    }
    ll sum = g;
    ll price = 0;
    sort(s.begin(), s.end(), [](station& o1, station& o2) {
        return o1.location < o2.location;
    });
    vector<ll> gas(n+1);
    vector<ll> prices;
    prices.reserve(s.size()+1);
    for(auto st : s) {
        prices.push_back(st.price);
    }
    prices.push_back(0);
    vector<bool> removed(n+1,false);
    gas[n] = g;
    auto ls = [&](int& o1, int& o2) {return prices[o1] > prices[o2];};
    auto lb = [&](int& o1, int& o2) {return prices[o1] < prices[o2];};
    priority_queue<int, vector<int>, decltype(ls)> mi(ls);
    priority_queue<int, vector<int>, decltype(lb)> ma(lb);
    mi.push(n);
    ma.push(n);
    ll prev = 0;
    for(int i = 0; i < n; i++) {
        ll remaining = s[i].location - prev;
        while(mi.size() && remaining != 0) {
            int top = mi.top();
            if(removed[top]) {
                mi.pop();
                continue;
            }
            ll sub = min(remaining, gas[top]);
            remaining -= sub;
            gas[top] -= sub;
            sum -= sub;
            price += prices[top] * sub;
            if(!gas[top]){
                removed[top] = true;
                mi.pop();
            } 
        }
        if(remaining) {
            cout << "cancel road trip" << endl;
            return 0 ;
        }
        while(ma.size() && prices[i] < prices[ma.top()]) {
            removed[ma.top()] = true;
            sum -= gas[ma.top()];
            ma.pop();
        }
        ma.push(i);
        mi.push(i);
        gas[i] = g-sum;
        sum = g;
        prev = s[i].location;
    }
    cout << price << endl;
  
}