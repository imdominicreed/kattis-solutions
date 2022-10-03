#include <bits/stdc++.h>

using namespace std;
using cd = complex<double>;

void fft(vector<cd>& a, bool invert) {
  int n = a.size();
  if (n == 1) return;
  cd w = 1;
  double angle = 2 * M_PI / n * (invert ? -1 : 1);
  cd wn(cos(angle), sin(angle));

  vector<cd> even;
  vector<cd> odd;
  for (int i = 0; i * 2 < n; i++) {
    even.push_back(a[i * 2]);
    odd.push_back(a[i * 2 + 1]);
  }
  fft(even, invert);
  fft(odd, invert);
  int op = n / 2;

  for (int i = 0; i * 2 < n; i++) {
    a[i] = even[i] + w * odd[i];
    a[i + op] = even[i] - w * odd[i];
    if (invert) {
      a[i] /= 2;
      a[i + op] /= 2;
    }
    w *= wn;
  }
}

vector<long> fft_multiply(vector<cd>& a, vector<cd>& b) {
  int n = 1;
  while (n < a.size() + b.size()) n <<= 1;
  a.resize(n);
  b.resize(n);
  fft(a, false);
  fft(b, false);
  for (int i = 0; i < n; i++) {
    a[i] *= b[i];
  }

  fft(a, true);
  vector<long> ret;
  for (auto n : a) ret.push_back(round(n.real()));
  return ret;
}

int main() {
  vector<cd> a;
  vector<cd> b;
  int off = 50'001;
  a.resize(2 * off);
  b.resize(2 * off);
  int n;
  cin >> n;
  long long zs = 0;
  vector<int> nums;
  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;
    if (!num) zs++;
    nums.push_back(num);
    num += off;
    a[num] += 1;
    b[num] += 1;
  }
  auto freq = fft_multiply(a, b);
  long long ret = 0;
  for (int num : nums) freq[2 * (num + off)]--;
  for (int num : nums) ret += freq[num + (2 * off)];
  ret -= 2LL * zs * (zs - 1);
  ret -= 2LL * zs * (n - zs);

  cout << ret << endl;
}