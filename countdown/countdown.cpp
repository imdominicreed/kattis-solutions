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
struct op {
    int a;
    int b;
    char op;
};
int do_op(int a, int b, char op) {
    if(op=='+') return a+b;
    if(op == '-') return a-b;
    if(op=='/') return a/b;
    return a*b;
}
vector<char> ops = {'+','-','*','/'};
void dfs(vector<op>& stack, vector<op>& best, int* apprx, vector<int>& numbers, int target) {
    if(numbers.size() == 1) return;
    for(int i = 0; i < numbers.size(); i++) {
        for(int j = 0; j < numbers.size(); j++) {
            if(i==j) continue;
            int a = numbers[i];
            int b = numbers[j];
            vector<int> next = numbers;
            next.erase(next.begin()+i);  
            if(i < j) next.erase(next.begin()+j-1);
            else next.erase(next.begin()+j);
            for(auto op: ops) {
                if ((op == '+' || op =='*')  && j < i) continue;
                if(op == '/' && a % b) continue;
                int num = do_op(a,b,op);
                if(num <= 0) continue;
                stack.push_back({a,b,op});
                if(abs(num-target) < *apprx) {
                    best = stack;
                    *apprx = abs(num-target);
                }
                if(!apprx) return;
                vector<int> child = next;
                child.push_back(num);
                dfs(stack, best, apprx, child, target);
                stack.pop_back();
            }
        }
    }
}
    

void solve(vector<int>& numbers, int target) { 
    vector<op> best;
    vector<op> stack;
    int apprx = abs(target-numbers[0]); 
    for(int num : numbers) apprx = min(apprx, abs(target-num));
    if(apprx) dfs(stack, best, &apprx, numbers, target);
    cout << "Target: " << target << endl;
    int output = target;
    for(auto op: best) {
        output = do_op(op.a,op.b,op.op);
        cout << op.a << ' ' << op.op << ' ' << op.b << " = " << output << endl;
    }
    cout << "Best approx: " << output  << endl << endl;


}

int main() {
    int n; cin >> n;
    for(int i = 0; i < n; i++) {
        vector<int> numbers(6);
        for(int i = 0; i < 6; i++) cin >> numbers[i];
        int target; cin>> target;
        solve(numbers, target);
    }
}
