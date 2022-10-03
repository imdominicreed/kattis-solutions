#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, k; cin >> n >> k;
	vector<int> set(k,0);
	string str;
	for(int i = 0; i < n; i++) {
		int curr = 0;
		cin >> str;
		for(int j = 0; j < k; j++) {
			char letter = str[j];
			int mask = 1 << (letter - 'A');
			curr |= mask;
			set[letter - 'A'] |= curr;
		}	
	}
	int curr_set = 0;
	int count = 0;
	while(true) {
			int best = (1 << k) - 1;
			for(int i = 0; i < k; i++) {
				int mask = 1 << i;
				if (curr_set & mask) continue;
				int flex = curr_set | set[i];
				if (__builtin_popcount(best) >= __builtin_popcount(flex)) {
						best = flex;
				}
			}
			count++;
			if(best == (1 << k) - 1) break;
			curr_set |= best;
	}
	cout << count << endl;
}
