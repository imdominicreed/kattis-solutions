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
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for(int i = 0 ; i < n; i++) {
        cin >> arr[i];
    }
    vector<int> freq(n);
    vector<int> ind(n);
    for(int i = 0 ; i < n; i++) {
        for(int num : arr) 
            if(arr[i] == num)
                freq[i]++;
    }
    for(int i = 0 ; i < n; i++) {
        for(int j = 0 ; j < n; j++) {
            if(arr[i] == arr[j]) {
                ind[i] = j;
                break;
            }
        }
    }
    vector<int> arrInd;
    for(int i = 0; i < n; i++) arrInd.push_back(i); 
    sort(arrInd.begin(), arrInd.end(), [freq, ind](int o1, int o2) {
        if(freq[o1] != freq[o2]) return freq[o2] < freq[o1];
        return ind[o1] < ind[o2];
    });
    for(int num : arrInd) cout << arr[num] << " ";
}