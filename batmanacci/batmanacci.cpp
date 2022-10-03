#include <bits/stdc++.h>

using namespace std;

int main() {
	int n;
	long long k; cin >> n >> k;
	vector<long long> fib(90);
	k--;
	fib[1] = 1;
	fib[2] = 1;
	for(int i = 3; i < 90; i++) fib[i] = fib[i-1] + fib[i-2]; 
	int curr = n;
	while(curr != 1 && curr != 2) {
		if(curr < 90 && k >= fib[curr-2]) {
			k -= fib[curr-2];
			curr -= 1;
		} else {
			curr -= 2;
		}
	}
	if(curr == 1) cout << "N";
	else cout << "A";
}
	
			
